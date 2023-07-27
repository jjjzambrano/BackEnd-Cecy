package cecy.cecy_backend.cecy_certificados.reportes;



import java.io.FileNotFoundException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import java.util.Map;


import cecy.cecy_backend.cecy_certificados.matriculas.MatriculasService;
import net.sf.jasperreports.engine.JRException;


@RestController
@RequestMapping("api/reporte")
@CrossOrigin({"*"})
public class ReporteController {
    @Autowired ReporteService reporteService;
    @Autowired MatriculasService matriculasService;
    @GetMapping("/")
    public List<Reporte> findAll(){
        return reporteService.findAll();
    }

    @GetMapping("/{id}/")
    public Reporte findById(@PathVariable Long id){
        return reporteService.findById(id);
    }

    @PostMapping("/")
    public Reporte save(@RequestBody Reporte entity){
        return reporteService.save(entity);
    }

    @PutMapping("/{id}/")
    public Reporte update(@RequestBody Reporte entity){
        return reporteService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        reporteService.deleteById(id);
    }

    @PatchMapping("/{id}/")
    public Reporte updateReporteByFields(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return  reporteService.updateReporteByFields(id,fields);
    }
    @GetMapping("/xls/{id}/")
    public ResponseEntity<byte[]> exportXls(@PathVariable Long id) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8");
        var contentDisposition = ContentDisposition.builder("attachment")
                .filename("reporte" + ".xls").build();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity.ok()
                .headers(headers)
                .body(reporteService.exportXls(id));
    }





}
