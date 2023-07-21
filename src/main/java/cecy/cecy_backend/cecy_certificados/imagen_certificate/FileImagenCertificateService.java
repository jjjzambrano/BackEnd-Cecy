package cecy.cecy_backend.cecy_certificados.imagen_certificate;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.ArrayList;

@Service
public class FileImagenCertificateService implements ImagenCertificateService{
    
    @Value("${media.location}")
    private String mediaLocation;
    private Path rootLocation;



    @Override
    @PostConstruct
    public void init() {
        rootLocation = Paths.get(mediaLocation);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String store(MultipartFile file){
        try{
            if(file.isEmpty()){
                throw new RuntimeException("Failed to store empty file");
            }
            String filename = file.getOriginalFilename();
            Path destinationFile = rootLocation.resolve(Paths.get(filename)).normalize().toAbsolutePath();
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return filename;
        } catch(IOException e){
            throw new RuntimeException("Failed to store file", e);
        }
    }

    @Override
    public Resource loadResource(String filename){
        try{
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource((file.toUri()));
            if(resource.exists() || resource.isReadable()){
                return resource;
            }else{
                throw new RuntimeException("Could not read file" + filename);
            }
        }catch(MalformedURLException e){
            throw new RuntimeException("Could not read file" + filename);
        }
    }


    public Optional<Resource> getResource(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            return resource.exists() && resource.isReadable() ? Optional.of(resource) : Optional.empty();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file" + filename, e);
        }
    }


    public List<ImagenInfo> getAll(String baseUrl) {
        try (Stream<Path> pathStream = Files.walk(rootLocation, 1)) {
            return pathStream
                    .filter(path -> !path.equals(rootLocation))
                    .map(path -> {
                        String imageName = rootLocation.relativize(path).toString();
                        String url = baseUrl + "/media/" + imageName;
                        return new ImagenInfo(imageName, url);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to get image names", e);
        }
    }
    public Optional<ImagenInfo> getImageByName(String imageName, String baseUrl) {
        try {
            Path file = rootLocation.resolve(imageName);
            if (Files.exists(file)) {
                String url = baseUrl + "/media/" + imageName;
                return Optional.of(new ImagenInfo(imageName, url));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get image by name", e);
        }
    }


    public boolean updateImageByName(String imageName, MultipartFile file) {
        try {
            Path existingFile = rootLocation.resolve(imageName);
            if (Files.exists(existingFile)) {
                // Delete the existing image
                Files.delete(existingFile);

                // Save the new image
                Files.copy(file.getInputStream(), existingFile);

                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to update image by name", e);
        }
    }

    public boolean deleteImageByName(String imageName) {
        try {
            Path file = rootLocation.resolve(imageName);
            if (Files.exists(file)) {
                Files.delete(file);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image by name", e);
        }
    }
}








