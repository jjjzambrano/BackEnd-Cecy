package cecy.cecy_backend.cecy_certificados.rol_certificado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("api/rol-certificado")
@CrossOrigin({"*"})
public class RolCertificadoController {
    
    @Autowired RolCertificadoService rolCertificadoService;

    @GetMapping("/")
    public List<RolCertificado> findAll(){
        return rolCertificadoService.findAll();
    }

    @GetMapping("/{id}/")
    public RolCertificado findById(@PathVariable Long id){
        return rolCertificadoService.findById(id);
    }

    @PostMapping("/")
    public RolCertificado save(@RequestBody RolCertificado entity){
        return rolCertificadoService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        rolCertificadoService.deleteById(id);
    }
}
