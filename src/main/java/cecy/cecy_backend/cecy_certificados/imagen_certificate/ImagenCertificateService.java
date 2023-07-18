package cecy.cecy_backend.cecy_certificados.imagen_certificate;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImagenCertificateService {
    void init();
    String store(MultipartFile file);
    Resource loadResource(String filename);
}
