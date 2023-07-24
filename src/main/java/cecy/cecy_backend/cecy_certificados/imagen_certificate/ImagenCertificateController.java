package cecy.cecy_backend.cecy_certificados.imagen_certificate;

import java.util.Map;

import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("api/media")
@CrossOrigin({"*"})
@AllArgsConstructor
public class ImagenCertificateController {


    private final ImagenCertificateService imagenCertificateService;
    private final FileImagenCertificateService fileImagenCertificateService;
    private final HttpServletRequest request;

    @PostMapping("/subir")
    public Map<String, String> uploadFile(@RequestParam("file")MultipartFile multipartFile){
        String path = imagenCertificateService.store(multipartFile);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(),"");
        String url = ServletUriComponentsBuilder.fromHttpUrl(host).path("/media/").path(path).toUriString();

        return Map.of("url",url);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ImagenInfo>> getAllImages(HttpServletRequest request) {
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        List<ImagenInfo> imageInfoList = fileImagenCertificateService.getAll(baseUrl);
        return ResponseEntity.ok(imageInfoList);
    }


    private void addFullImageUrl(List<ImagenInfo> images, HttpServletRequest request) {
        String baseUrl = getBaseUrl(request);
        for (ImagenInfo image : images) {
            image.setUrl(baseUrl + image.getUrl());
        }
    }

    private String getBaseUrl(HttpServletRequest request) {
        String baseUrl = request.getScheme() + "://" + request.getServerName();
        int port = request.getServerPort();
        if ((port != 80) && (port != 443)) {
            baseUrl += ":" + port;
        }
        return baseUrl;
    }

    @GetMapping("/get-by-name/{imageName}")
    public ResponseEntity<?> getImageByName(@PathVariable String imageName, HttpServletRequest request) {
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        Optional<ImagenInfo> imageInfo = fileImagenCertificateService.getImageByName(imageName, baseUrl);

        if (imageInfo.isPresent()) {
            return ResponseEntity.ok(imageInfo.get());
        } else {
            String errorMessage = "Imagen no encontrada: " + imageName;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PutMapping("/update-by-name/{imageName}")
    public ResponseEntity<UpdateImageResponse> updateImageByName(
            @PathVariable String imageName,
            @RequestParam("file") MultipartFile file) {
        boolean updated = fileImagenCertificateService.updateImageByName(imageName, file);

        if (updated) {
            UpdateImageResponse response = new UpdateImageResponse(
                    "Imagen con el nombre '" + imageName + "' fue actualizada exitosamente.",
                    true
            );
            return ResponseEntity.ok(response);
        } else {
            UpdateImageResponse response = new UpdateImageResponse(
                    "Imagen con el nombre '" + imageName + "' no fue encontrada.",
                    false
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/delete-by-name/{imageName}")
    public ResponseEntity<DeleteImageResponse> deleteImageByName(@PathVariable String imageName) {
        boolean deleted = fileImagenCertificateService.deleteImageByName(imageName);

        DeleteImageResponse response;
        if (deleted) {
            response = new DeleteImageResponse("Imagen con el nombre '" + imageName + "' fue borrada exitosamente.", true);
            return ResponseEntity.ok(response);
        } else {
            response = new DeleteImageResponse("Imagen con el nombre '" + imageName + "' no fue encontrada.", false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
