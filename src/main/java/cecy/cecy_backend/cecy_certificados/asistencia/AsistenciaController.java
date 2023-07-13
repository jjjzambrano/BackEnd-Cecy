package cecy.cecy_backend.cecy_certificados.asistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cecy.cecy_backend.cecy_certificados.catalogos.CatalogosService;

@RestController
@RequestMapping("api/asistencia")
@CrossOrigin({"*"})
public class AsistenciaController {
    @Autowired AsistenciaService asistenciaService;
    @Autowired CatalogosService catalogosService;
    @GetMapping("/")
    public List<Asistencia> findAll(){
        return asistenciaService.findAll();
    }

    @GetMapping("/{id}/")
    public Asistencia findById(@PathVariable Long id){
        return asistenciaService.findById(id);
    } 
    @GetMapping("/cursoId/{id}/")
    public List<Asistencia> findByCursoId(@PathVariable Integer id){
        return asistenciaService.findByCursoId(id);
    }

    @PostMapping("/")
    public Asistencia save(@RequestBody Asistencia entity){
        entity.getDetalleAsistencia().forEach(detalleAsistencia -> detalleAsistencia.setEstado(catalogosService.findFirstByDescription((detalleAsistencia.getEstado().getDescripcion()))));
        return asistenciaService.save(entity);
    }

    @PutMapping("/{id}/")
    public Asistencia update(@RequestBody Asistencia entity){
        return asistenciaService.save(entity);
    }
}