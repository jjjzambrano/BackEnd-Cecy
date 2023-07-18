package cecy.cecy_backend.cecy_certificados.links;

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
@RequestMapping("api/links")
public class LinksController {
    @Autowired LinksService linksService;
    @GetMapping("/")
    public List<Links> findAll(){
        return linksService.findAll();
    }

    @GetMapping("/{id}/")
    public Links findById(@PathVariable Long id){
        return linksService.findById(id);
    }

    @PostMapping("/")
    public Links save(@RequestBody Links entity){
        return linksService.save(entity);
    }

    @PutMapping("/{id}/")
    public Links update(@RequestBody Links entity){
        return linksService.save(entity);
    }

    
}