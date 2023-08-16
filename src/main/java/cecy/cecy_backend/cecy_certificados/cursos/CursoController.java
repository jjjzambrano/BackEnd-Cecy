package cecy.cecy_backend.cecy_certificados.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cecy.cecy_backend.cecy_certificados.cursos.conexion.Course;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.CursoApiFeignService;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.reportDto.CourseReportDto;
import cecy.cecy_backend.cecy_certificados.reportes.ReporteService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

// import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/cursos")
@CrossOrigin({ "*" })
public class CursoController {

    @Autowired
    CursoService cursoService;
    @Autowired
    CursoApiFeignService cursoApiFeignService;

    @GetMapping("/")
    public List<Curso> findAll() {
        return cursoService.getCourseAll();
    }

    @GetMapping("/{id}")
    public Curso findById(@PathVariable Long id) {
        return cursoService.findById(id);
    }

    /*
     * TOMAR EN CUENTA EL POST, YA QUE UN CURSO YA ESTA CREADO Y PARA QUE HAYA UN
     * NUEVO CURSO DEBE DE TENER
     * UNA PLANIFICACION DE POR MEDIO ASI QUE ESE ENDPOINT SE LO HIZO POR SIACASO
     * QUIERAN AGREGAR ALGO EN ESPECIAL
     * EN LA MAYORIA CREO QUE SE DEBERIA DE USAR UN UPDATE PARA ACTUALIZAR UN CURSO
     * Y SU ID EN ESPECIFICO
     */

    @PostMapping("/")
    public Curso saveCurso(@RequestBody Curso curso) {
        return cursoService.create(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCourse(@PathVariable Integer id, @RequestBody Curso curso) {
        return cursoService.updateById(id, curso);
    }

    @GetMapping("/reporte/design/{id}")
    public ResponseEntity<byte[]> getFacturaReporte(@PathVariable Integer id) throws JRException {
        JasperPrint reporte = cursoService.getReporteDesign(id);

        if (reporte == null)
            return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);

        HttpHeaders headers = new HttpHeaders();
        // set the PDF format
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "main.pdf");
        // create the report in PDF format
        return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(reporte), headers, HttpStatus.OK);

    }

    @GetMapping("/xls/{id}/design")
    public ResponseEntity<byte[]> exportXlsDesign(@PathVariable Integer id) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8");
        var contentDisposition = ContentDisposition.builder("attachment")
                .filename("reporte" + ".xls").build();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity.ok()
                .headers(headers)
                .body(cursoService.exportXls(id,"design"));
    }

    @GetMapping("/xls/{id}/need")
    public ResponseEntity<byte[]> exportXlsNeed(@PathVariable Integer id) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8");
        var contentDisposition = ContentDisposition.builder("attachment")
                .filename("reporte" + ".xls").build();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity.ok()
                .headers(headers)
                .body(cursoService.exportXls(id,"need"));
    }

    @GetMapping("/reporte/design/test/{id}")
    public CourseReportDto getTest(@PathVariable Integer id) throws JRException {
        return cursoApiFeignService.getPlanificationReportById(id);
    }

}
