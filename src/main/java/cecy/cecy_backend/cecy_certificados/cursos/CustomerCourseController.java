package cecy.cecy_backend.cecy_certificados.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/curso")
@CrossOrigin({"*"})
public class CustomerCourseController {
    @Autowired CustomerCourse customerCourse;
    @GetMapping("/")
    public List<CustomerDTOCourse> findAll(){
        return customerCourse.findCourse();
    }
    @GetMapping("/{id}/")
    public CustomerDTOCourse findById(@PathVariable Long id){
        return customerCourse.findCourseByIdDto(id);
    }
}
