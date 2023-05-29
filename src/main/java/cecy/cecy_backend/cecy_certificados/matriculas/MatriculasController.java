package cecy.cecy_backend.cecy_certificados.matriculas;

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
@RequestMapping("api/matriculas")
@CrossOrigin({"*"})
public class MatriculasController {

    @Autowired MatriculasService matriculasService;
    @GetMapping("/")
    public List<Matriculas> findAll(){
        return matriculasService.findAll();
    }

    @GetMapping("/{id}/")
    public Matriculas findById(@PathVariable Long id){
        return matriculasService.findById(id);
    }

    @GetMapping("/estadoMatricula/{term}/")
    public List<Matriculas> findByEstadoMatricula(@PathVariable String term) {
        return matriculasService.findByEstadoMatricula(term);
    }

    @PostMapping("/")
    public Matriculas save(@RequestBody Matriculas entity){
        return matriculasService.save(entity);
    }

    @PutMapping("/{id}/")
    public Matriculas update(@RequestBody Matriculas entity){
        return matriculasService.save(entity);
    }
    
}
