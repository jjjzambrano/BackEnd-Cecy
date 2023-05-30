package cecy.cecy_backend.cecy_certificados.observaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/observaciones")
public class ObservacionesController {
    @Autowired ObservacionesService observacionesService;
    @GetMapping("/")
    public List<Observaciones> findAll(){
        return observacionesService.findAll();
    }

    @GetMapping("/{id}/")
    public Observaciones findById(@PathVariable Long id){
        return observacionesService.findById(id);
    }

    @PostMapping("/")
    public Observaciones save(@RequestBody Observaciones entity){
        return observacionesService.save(entity);
    }

    @PutMapping("/{id}/")
    public Observaciones update(@RequestBody Observaciones entity){
        return observacionesService.save(entity);
    }

    
}
