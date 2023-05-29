package cecy.cecy_backend.cecy_certificados.detalleAsistencia;

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
@RequestMapping("api/detalleAsistencia")
@CrossOrigin({"*"})
public class DetalleAsistenciaController {

    @Autowired DetalleAsistenciaService detalleAsistenciaService;
    @Autowired CatalogosService catalogosService;

    @GetMapping("/")
    public List<DetalleAsistencia> findAll(){
        return detalleAsistenciaService.findAll();
    }

    @GetMapping("/{id}/")
    public DetalleAsistencia findById(@PathVariable Long id){
        return detalleAsistenciaService.findById(id);
    }

    @PostMapping("/")
    public DetalleAsistencia save(@RequestBody DetalleAsistencia entity){
        return detalleAsistenciaService.save(entity);
    }

    @PutMapping("/{id}/")
    public DetalleAsistencia update(@RequestBody DetalleAsistencia entity){
        return detalleAsistenciaService.save(entity);
    }
    
}
