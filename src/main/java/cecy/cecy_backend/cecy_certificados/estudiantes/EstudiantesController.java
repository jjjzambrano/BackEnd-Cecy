package cecy.cecy_backend.cecy_certificados.estudiantes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estudiantes")
@CrossOrigin({ "*" })
public class EstudiantesController {

    @Autowired
    EstudiantesService estudiantesService;

    @GetMapping("/")
    public List<Estudiantes> findAll() {
        return estudiantesService.findAll();
    }

    @GetMapping("/{id}/")
    public Estudiantes findById(@PathVariable Long id) {
        return estudiantesService.findById(id);
    }

    @PostMapping("/")
    public Estudiantes save(@RequestBody Estudiantes estudiantes) {
        return estudiantesService.save(estudiantes);
    }
}