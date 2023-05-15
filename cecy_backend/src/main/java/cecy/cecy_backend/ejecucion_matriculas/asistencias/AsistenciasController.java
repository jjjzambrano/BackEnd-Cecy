package cecy.cecy_backend.ejecucion_matriculas.asistencias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/asistencia")
@CrossOrigin({"*"})
public class AsistenciasController {
    @Autowired AsistenciasService asistenciaService;


    //GET
    @GetMapping("/")
    public List<Asistencias> findAll(){
        return asistenciaService.findAll();
    }

    @GetMapping("/{id}/")
    public Asistencias findById(@PathVariable Long id){
        return asistenciaService.findById(id);
    }

    //GUARDAR
    @PostMapping("/")
    public Asistencias save(@RequestBody Asistencias entity){
        return asistenciaService.save(entity);
    }

    //ACTUALIZAR
    @PutMapping("/{id}/")
    public Asistencias update(@RequestBody Asistencias entity) {
        return asistenciaService.save(entity);
    }

    //ELIMINAR
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        asistenciaService.deleteById(id);
    }
}
