package cecy.cecy_backend.cecy_certificados.cursos.conexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin({"*"})
public class CursoApiFeignController {
    @Autowired
    CursoApiFeignService cursoApiFeignService;
    @GetMapping("/courses")
    public List<Course> getCoursesAll() {
        return cursoApiFeignService.getCoursesAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseId(@PathVariable Integer id) {
        return cursoApiFeignService.getCourseById(id);
    }
    @GetMapping("/courses/state-course/{state}/")
    public  List<Course> getCoursesByState(@PathVariable String state){
        return cursoApiFeignService.getCoursesByState(state);
    }

    @GetMapping("/planifications-courses/{id}") // Se necesita en el certificado NO TOQUE
    public Planificacion getPlanificacion(@PathVariable Integer id){
        return cursoApiFeignService.getPlanificationId(id);
    }

    @GetMapping("/courses/find/instructor/{id}")
    public List<DetallePlanificacion> getCoursesInstructor(@PathVariable Integer id){
        return cursoApiFeignService.getCoursesByInstructor(id);
    }
}
