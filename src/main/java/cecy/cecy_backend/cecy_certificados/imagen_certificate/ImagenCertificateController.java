package cecy.cecy_backend.cecy_certificados.imagen_certificate;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.HashMap;
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

  /*  @Value("${media.location}")
    private String mediaLocation;*/

/*    @GetMapping("/images")
    public ResponseEntity<List<Map<String, String>>> getAllImageUrls() {
        List<String> imageUrls = fileImagenCertificateService.getAllImageUrls();
        List<Map<String, String>> urlList = imageUrls.stream()
                .map(imageUrl -> {
                    String imageName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
                    Map<String, String> urlMap = new HashMap<>();
                    urlMap.put("url", imageUrl);
                    urlMap.put("imageName", imageName);
                    return urlMap;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(urlList);
    }*/

    @PostMapping("/subir")
    public Map<String, String> uploadFile(@RequestParam("file")MultipartFile multipartFile){
        String path = imagenCertificateService.store(multipartFile);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(),"");
        String url = ServletUriComponentsBuilder.fromHttpUrl(host).path("/media/").path(path).toUriString();

        return Map.of("url",url);
    }
}
