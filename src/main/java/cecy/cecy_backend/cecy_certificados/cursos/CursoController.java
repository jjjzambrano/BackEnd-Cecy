package cecy.cecy_backend.cecy_certificados.cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /*TOMAR EN CUENTA EL POST, YA QUE UN CURSO YA ESTA CREADO Y PARA QUE HAYA UN NUEVO CURSO DEBE DE TENER
    * UNA PLANIFICACION DE POR MEDIO ASI QUE ESE ENDPOINT SE LO HIZO POR SIACASO QUIERAN AGREGAR ALGO EN ESPECIAL
    * EN LA MAYORIA CREO QUE SE DEBERIA DE USAR UN UPDATE PARA ACTUALIZAR UN CURSO Y SU ID EN ESPECIFICO
    * */


    @PostMapping("/")
    public Curso saveCurso(@RequestBody Curso curso){
        return cursoService.create(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCourse(@PathVariable Integer id, @RequestBody Curso curso){
        return cursoService.updateById(id, curso);
    }
}
