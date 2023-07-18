package cecy.cecy_backend.cecy_certificados.firma;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cecy.cecy_backend.cecy_certificados.imagen_certificate.ImagenCertificateService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/firma")
@CrossOrigin({"*"})
public class FirmasController {
    @Autowired FirmasService firmasService;
    @Autowired ImagenCertificateService imagenCertificateService;
    @Autowired HttpServletRequest request;
    @GetMapping("/")
    public List<Firmas> findAll(){
        return firmasService.findAll();
    }

    @GetMapping("/{id}/")
    public Firmas findById(@PathVariable Long id){
        return firmasService.findById(id);
    }

    @PostMapping("/")
    public Firmas save(@RequestBody Firmas entity){
        return firmasService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        firmasService.deleteById(id);
    }
}
