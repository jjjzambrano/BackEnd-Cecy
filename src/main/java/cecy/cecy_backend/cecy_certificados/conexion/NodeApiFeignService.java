package cecy.cecy_backend.cecy_certificados.conexion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "nodeApi", url = "http://localhost:3000/api/v1")
public interface NodeApiFeignService {
    @GetMapping("/courses")
    List<Course> getCoursesAll();  /*Aqui te trae todos los cursos*/
    @GetMapping("/courses/state-course/{state}")
    List<Course> getCoursesByState(@PathVariable("state") String state); /*Aqui busco los cursos por estado (proceso | aprobado)*/
}
