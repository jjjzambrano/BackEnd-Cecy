package cecy.cecy_backend.cecy_certificados.catalogos;

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
@RequestMapping("api/catalogos")
@CrossOrigin({"*"})
public class CatalogosController {
    @Autowired CatalogosService catalogosService;

    @GetMapping("/")
    public List<Catalogos> findAll(){
        return catalogosService.findAll();
    }

    @GetMapping("/{id}/")
    public Catalogos findById(@PathVariable Long id){
        return catalogosService.findById(id);
    }

    @PostMapping("/")
    public Catalogos save(@RequestBody Catalogos entity){
        return catalogosService.save(entity);
    }

    @PutMapping("/{id}/")
    public Catalogos update(@RequestBody Catalogos entity){
        return catalogosService.save(entity);
    }
    
}
