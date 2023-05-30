package cecy.cecy_backend.cecy_certificados.estudiantes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PutMapping;
>>>>>>> main
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cecy.cecy_backend.cecy_certificados.catalogos.CatalogosService;

@RestController
@RequestMapping("api/estudiantes")
@CrossOrigin({ "*" })

public class EstudiantesController {
    @Autowired
    EstudiantesService estudiantesService;
    @Autowired
    CatalogosService catalogosService;

    @GetMapping("/")
    public List<Estudiantes> findAll() {
        return estudiantesService.findAll();
    }

    @GetMapping("/{id}/")
    public Estudiantes findById(@PathVariable Long id) {
        return estudiantesService.findById(id);
    }

    @PostMapping("/")
    public Estudiantes save(@RequestBody Estudiantes entity) {
        entity.setGenero(catalogosService.findByDescripcion(entity.getGenero().getDescripcion()));
        entity.setTipoEstudiante(catalogosService.findByDescripcion(entity.getTipoEstudiante().getDescripcion()));
        entity.setNivelInstruccion(catalogosService.findByDescripcion(entity.getNivelInstruccion().getDescripcion()));
        entity.setSituacionEconomica(catalogosService.findByDescripcion(entity.getSituacionEconomica().getDescripcion()));
        return estudiantesService.save(entity);
    }

    @PutMapping("/{id}/")
    public Estudiantes update(@RequestBody Estudiantes entity) {
        return estudiantesService.save(entity);
    }

}
