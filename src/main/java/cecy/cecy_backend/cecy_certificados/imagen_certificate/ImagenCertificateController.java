package cecy.cecy_backend.cecy_certificados.imagen_certificate;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/media")
@CrossOrigin({"*"})
@AllArgsConstructor
public class ImagenCertificateController {
    

    private final ImagenCertificateService imagenCertificateService;
    private final HttpServletRequest request;

    @PostMapping("/subir")
    public Map<String, String> uploadFile(@RequestParam("file")MultipartFile multipartFile){
        String path = imagenCertificateService.store(multipartFile);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(),"");
        String url = ServletUriComponentsBuilder.fromHttpUrl(host).path("/media/").path(path).toUriString();

        return Map.of("url",url);
    }
}
