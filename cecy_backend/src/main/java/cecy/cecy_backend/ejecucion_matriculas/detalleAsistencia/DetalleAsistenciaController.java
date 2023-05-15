package cecy.cecy_backend.ejecucion_matriculas.detalleAsistencia;

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
@RequestMapping("api/detalleAsistencia")
@CrossOrigin({"*"})
public class DetalleAsistenciaController {
    @Autowired DetalleAsistenciaService detalleasistenciaService;


    //GET
    @GetMapping("/")
    public List<DetalleAsistencia> findAll(){
        return detalleasistenciaService.findAll();
    }

    @GetMapping("/{id}/")
    public DetalleAsistencia findById(@PathVariable Long id){
        return detalleasistenciaService.findById(id);
    }

    //GUARDAR
    @PostMapping("/")
    public DetalleAsistencia save(@RequestBody DetalleAsistencia entity){
        return detalleasistenciaService.save(entity);
    }

    //ACTUALIZAR
    @PutMapping("/{id}/")
    public DetalleAsistencia update(@RequestBody DetalleAsistencia entity) {
        return detalleasistenciaService.save(entity);
    }

    //ELIMINAR
    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        detalleasistenciaService.deleteById(id);
    }
}
