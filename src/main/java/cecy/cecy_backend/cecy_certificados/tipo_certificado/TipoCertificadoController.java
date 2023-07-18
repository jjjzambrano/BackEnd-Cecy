package cecy.cecy_backend.cecy_certificados.tipo_certificado;

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
@RequestMapping("api/tipo-certificado")
@CrossOrigin({"*"})
public class TipoCertificadoController {
    
    @Autowired TipoCertificadoService tipoCertificadoService;

    @GetMapping("/")
    public List<TipoCertificado> findAll(){
        return tipoCertificadoService.findAll();
    }

    @GetMapping("/{id}/")
    public TipoCertificado findById(@PathVariable Long id){
        return tipoCertificadoService.findById(id);
    }

    @PostMapping("/")
    public TipoCertificado save(@RequestBody TipoCertificado entity){
        return tipoCertificadoService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        tipoCertificadoService.deleteById(id);
    }
}
