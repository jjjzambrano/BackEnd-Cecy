package cecy.cecy_backend.cecy_certificados.certificados_generados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/generado")
@CrossOrigin({"*"})
public class CertificadosGeneradosController {
    @Autowired CertificadosGeneradosService certificadosGeneradosService;

    @GetMapping("/")
    public List<CertificadosGenerados> findAll(){
        return certificadosGeneradosService.findAll();
    }

    @GetMapping("/{id}/")
    public CertificadosGenerados findById(@PathVariable Long id){
        return certificadosGeneradosService.findById(id);
    }

    @PostMapping("/")
    public CertificadosGenerados save(@RequestBody CertificadosGenerados entity){
        return certificadosGeneradosService.save(entity);
    }

    @PutMapping("/{id}/")
    public CertificadosGenerados update(@RequestBody CertificadosGenerados entity){
        return certificadosGeneradosService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        certificadosGeneradosService.deleteById(id);
    }
}