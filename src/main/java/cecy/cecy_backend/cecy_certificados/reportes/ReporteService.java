package cecy.cecy_backend.cecy_certificados.reportes;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import cecy.cecy_backend.cecy_certificados.codigos.Codigos;
import cecy.cecy_backend.cecy_certificados.cursos.Curso;
import cecy.cecy_backend.cecy_certificados.cursos.CursoService;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.Categoria;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.CursoApiFeignService;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.Planificacion;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
public class ReporteService {
    @Autowired ReporteRepository entityRepository;
    @Autowired CursoService cursoService;
    @Autowired
    CursoApiFeignService planificationService;
    public Reporte save(Reporte entity) {
        return entityRepository.save(entity);
    }

    public Reporte findById(Long id) {
        return entityRepository.findById(id).orElse(new Reporte());
    }

    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }

    public List<Reporte> findAll() {
        return entityRepository.findAll();
    }

    public JasperPrint getReporte(Long id) {

        Map<String, Object> reportParameters = new HashMap<String, Object>();
        Reporte reporte = findById(id);
        Long cursoId = new Long(0);
        int aprobado = 0;
        int reprobado = 0;
        if (reporte.getId() == null)
            return null;
            
        for(Codigos codigos: reporte.getReportes()){
            String matricula = codigos.getMatriculas().getEstadoCurso().getDescripcion();
            cursoId =  codigos.getMatriculas().getCursoId();
            if(matricula.equals("Aprobado")){
                aprobado = aprobado+1;
            }
            if(matricula.equals("Reprobado")){
                reprobado = reprobado+1;
            }
        }
        
        
        reportParameters.put("estudiantes_apro", aprobado);
        reportParameters.put("estudiantes_repro", reprobado);
        reportParameters.put("total", aprobado+reprobado);
        Curso curso = cursoService.findById(cursoId);
        Planificacion planificacion = planificationService.getPlanificationId(curso.getPlanificationId());
        reportParameters.put("nombre_curso", planificacion.getName());
        
        reportParameters.put("docente", planificacion.getUser().getNames());
        reportParameters.put("fecha_inicio", planificacion.getStartDate());
        reportParameters.put("fecha_fin", planificacion.getFinishDate());
        reportParameters.put("nombre_instituto", "Instituto Tecnologico Yavirac");
        //Categoria categoria = planificationService.getCourseById(curso.getCategoryId());
        //reportParameters.put("area_curso", curso.getCategoryId());
        

        List<Map<String, Object>> dataList = new ArrayList<>();
        
        for (Codigos codigos : reporte.getReportes()) {
            Map<String, Object> data = new HashMap<>();
            Period edad = Period.between(codigos.getMatriculas().getEstudiantes().getFechaNacimiento().toLocalDate(), LocalDate.now());
            data.put("nombreEstudiante", codigos.getMatriculas().getEstudiantes().getNombres());
            data.put("apellidoEstudiante", codigos.getMatriculas().getEstudiantes().getApellidos());
            data.put("noCedula", codigos.getMatriculas().getEstudiantes().getCedula());
            data.put("autodefinicion", codigos.getMatriculas().getEstudiantes().getEtnia().getDescripcion());
            data.put("discapacidad", codigos.getMatriculas().getEstudiantes().getDetallesDiscapacidad());
            data.put("edad", edad.getYears());
            data.put("genero", codigos.getMatriculas().getEstudiantes().getGenero().getDescripcion());
            data.put("correo", codigos.getMatriculas().getEstudiantes().getEmail());
            data.put("codigo", codigos.getCodigo());
            dataList.add(data);
        }
        reportParameters.put("listaReporte", new JRBeanCollectionDataSource(dataList));

        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:jrxml/reporte.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }

    public byte[] exportToXls( Long id) throws JRException{
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        SimpleOutputStreamExporterOutput output = new SimpleOutputStreamExporterOutput(byteArray);
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(getReporte(id)));
        exporter.setExporterOutput(output);
        exporter.exportReport();
        output.close();
        return byteArray.toByteArray();
    }
    public byte[] exportXls(Long id) throws JRException {
        return exportToXls(id);
    }
}
