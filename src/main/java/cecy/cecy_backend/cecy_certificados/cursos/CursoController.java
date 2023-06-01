package cecy.cecy_backend.cecy_certificados.cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/cursos")
@CrossOrigin
public class CursoController {
    @Autowired CursoService cursoService;

    @GetMapping("/")
    public List<Curso> findAll(){
        return cursoService.getCourseAll();
    }

    @GetMapping("/{id}")
    public Curso findById(@PathVariable Long id) {
        return cursoService.findById(id);
    }

    @PostMapping("/")
    public Curso saveCurso(@RequestBody Curso curso){
        return cursoService.create(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCourse(@RequestBody Curso curso){
         return cursoService.updateById(curso);
    }
}
