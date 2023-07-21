package cecy.cecy_backend.cecy_certificados.imagen_certificate;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ImagenCertificateService {
    void init();
    String store(MultipartFile file);
    Resource loadResource(String filename);
/*
    Optional<ImagenInfo> getImageByName(String imageName);
*/

}
