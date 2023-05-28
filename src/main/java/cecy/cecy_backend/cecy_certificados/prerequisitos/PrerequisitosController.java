package cecy.cecy_backend.cecy_certificados.prerequisitos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prerequisitos")
@CrossOrigin({"*"})
public class PrerequisitosController {

    @Autowired PrerequisitosService prerequisitosService;

    @GetMapping("/")
    public List<Prerequisitos> findAll(){
        return prerequisitosService.findAll();
    }

    @GetMapping("/{id}/")
    public Prerequisitos findById(@PathVariable Long id){
        return prerequisitosService.findById(id);
    }

    @PostMapping("/")
    public Prerequisitos save(@RequestBody Prerequisitos entity){
        return prerequisitosService.save(entity);
    }

    @PutMapping("/{id}/")
    public Prerequisitos update(@RequestBody Prerequisitos entity){
        return prerequisitosService.save(entity);
    }
    
}
