package cecy.cecy_backend.cecy_certificados.codigos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

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
    public Codigos update(@PathVariable Long id, @RequestBody Codigos entity){
        return codigosService.update(id,entity);
    }
    
    @PatchMapping("/{id}/")
    public Codigos updateCodigotByFields(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return codigosService.updateCodigotByFields(id,fields);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        codigosService.deleteById(id);
    }
}
