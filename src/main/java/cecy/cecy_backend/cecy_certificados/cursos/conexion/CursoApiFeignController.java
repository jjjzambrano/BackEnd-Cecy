package cecy.cecy_backend.cecy_certificados.cursos.conexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin({"*"})
public class CursoApiFeignController {
    @Autowired
    CursoApiFeignService cursoApiFeignService;
    @GetMapping("/courses")
    public List<Course> getCoursesAll() {
        return cursoApiFeignService.getCoursesAll();
    }
    @GetMapping("/courses/state-course/{state}")
    public  List<Course> getCoursesByState(@PathVariable String state){
        return cursoApiFeignService.getCoursesByState(state);
    }
}
