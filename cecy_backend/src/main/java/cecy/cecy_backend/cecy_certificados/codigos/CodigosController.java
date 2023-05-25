package cecy.cecy_backend.cecy_certificados.codigos;

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
@RequestMapping("api/codigo")
@CrossOrigin({"*"})
public class CodigosController {
    @Autowired CodigosService codigosService;

    @GetMapping("/")
    public List<Codigos> findAll(){
        return codigosService.findAll();
    }

    @GetMapping("/{id}/")
    public Codigos findById(@PathVariable Long id){
        return codigosService.findById(id);
    }

    @PostMapping("/")
    public Codigos save(@RequestBody Codigos entity){
        return codigosService.save(entity);
    }

    @PutMapping("/{id}/")
    public Codigos update(@RequestBody Codigos entity){
        return codigosService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        codigosService.deleteById(id);
    }
}
