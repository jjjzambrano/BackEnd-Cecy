package cecy.cecy_backend.cecy_certificados.cursos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import cecy.cecy_backend.cecy_certificados.codigos.Codigos;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.Categoria;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.Course;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.CursoApiFeignService;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.Planificacion;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.reportDto.CourseReportDto;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.reportDto.EnvironmentDto;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.reportDto.EvaluationDto;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.reportDto.ScheduleDto;
import cecy.cecy_backend.cecy_certificados.reportes.Reporte;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Transactional
@Service
public class CursoService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    CursoApiFeignService cursoApiFeignService;

    /* Ver todos los cursos */
    public List<Curso> getCourseAll() {
        return cursoRepository.findAll();
    }

    /* Busqueda por Id */
    public Curso findById(long id) {
        return cursoRepository.findById(id).orElse(new Curso());
    }

    /* Agregar nueva informacion en sus campos nuevos */

    public Curso create(Curso curso) {
        return cursoRepository.save(curso);
    }

    /* Actualizar el curso por id */
    public Curso updateById(Integer id, Curso cursodto) {
        Curso curso = cursoRepository.findById(id.longValue())
                .orElseThrow(() -> new NoSuchElementException("No se encontró el curso con el ID: " + id));
        BeanUtils.copyProperties(cursodto, curso, "id");
        return cursoRepository.save(curso);
    }

    public JasperPrint getReporteNeed(Integer id) {
        CourseReportDto curso = cursoApiFeignService.getPlanificationReportById(id);

        // CourseReportDto datos = planification.get(0);

        Map<String, Object> reportParameters = new HashMap<String, Object>();

        reportParameters.put("codeCourse", curso.getCodeCourse());
        reportParameters.put("teacher", curso.getTeacher());
        reportParameters.put("nameCourse", curso.getNameCourse());
        reportParameters.put("type", curso.getType());
        reportParameters.put("modality", curso.getModality());
        // reportParameters.put("justify", curso.getJustify());
        reportParameters.put("duration", curso.getDuration());
        reportParameters.put("startedDate", curso.getStartedDate());
        reportParameters.put("endedDate", curso.getEndedDate());

        reportParameters.put("participantRegister", curso.getParticipantRegister());
        reportParameters.put("summary", curso.getSummary());
        reportParameters.put("project", curso.getProject());
        reportParameters.put("participantTypes", curso.getParticipantTypes());

        List<Map<String, Object>> horarioList = new ArrayList<>();

        for (ScheduleDto horario : curso.getSchedule()) {
            Map<String, Object> data = new HashMap<>();
            data.put("endedTime", horario.getEndedTime());
            data.put("startedTime", horario.getStartedTime());
            data.put("days", horario.getDays());
            data.put("workday", horario.getWorkday());
            horarioList.add(data);
        }
        reportParameters.put("schedule", new JRBeanCollectionDataSource(horarioList));

        List<Map<String, Object>> justifyList = new ArrayList<>();

        for (String justify : curso.getJustify()) {
            Map<String, Object> data = new HashMap<>();
            data.put("justify", justify);
            justifyList.add(data);
        }
        reportParameters.put("justify", new JRBeanCollectionDataSource(justifyList));

        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:jrxml/needs.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }

    public JasperPrint getReporteDesign(Integer id) {
        CourseReportDto curso = cursoApiFeignService.getDesignReportById(id);

        // CourseReportDto datos = planification.get(0);

        Map<String, Object> reportParameters = new HashMap<String, Object>();

        // reportParameters.put("nameCourse", curso.getNameCourse());
        // reportParameters.put("modality", curso.getModality());
        // reportParameters.put("duration", curso.getDuration());
        // reportParameters.put("participantTypes", curso.getParticipantTypes());
        // reportParameters.put("area", curso.getDuration());
        // reportParameters.put("duration", curso.getDuration());

        List<Map<String, Object>> headerFirstData = new ArrayList<>();

        Map<String, Object> data = new HashMap<>();
        data.put("nameCourse", curso.getNameCourse());
        data.put("area", curso.getArea());
        data.put("especiality", curso.getSpeciality());
        headerFirstData.add(data);

        reportParameters.put("headerFirst", new JRBeanCollectionDataSource(headerFirstData));

        List<Map<String, Object>> headerSecondData = new ArrayList<>();

        Map<String, Object> dataheaderSecond = new HashMap<>();
        dataheaderSecond.put("participantTypes", curso.getParticipantTypes());
        dataheaderSecond.put("modality", curso.getModality());
        dataheaderSecond.put("duration", curso.getDuration());
        headerSecondData.add(dataheaderSecond);

        reportParameters.put("headerSecond", new JRBeanCollectionDataSource(headerSecondData));

        reportParameters.put("requireTechnique", curso.getRequireTechnique());
        reportParameters.put("requireGeneral", curso.getRequireGeneral());
        reportParameters.put("object", curso.getObject());
        reportParameters.put("strategy", curso.getStrategy());

        List<Map<String, Object>> evaluationDiagnosticData = new ArrayList<>();

        Map<String, Object> evaluationDiagnostic = new HashMap<>();
        for (EvaluationDto dataEvaluationDiagnostic : curso.getEvaluationDiagnostic()) {
            evaluationDiagnostic.put("technique", dataEvaluationDiagnostic.getTechnique());
            evaluationDiagnostic.put("instrument", dataEvaluationDiagnostic.getInstrument());
            evaluationDiagnosticData.add(evaluationDiagnostic);
        }

        reportParameters.put("evaluationDiagnostic", new JRBeanCollectionDataSource(evaluationDiagnosticData));

        List<Map<String, Object>> evaluationFormativeData = new ArrayList<>();

        Map<String, Object> evaluationFormative = new HashMap<>();
        for (EvaluationDto dataEvaluationFormative : curso.getEvaluationFormative()) {
            evaluationFormative.put("technique", dataEvaluationFormative.getTechnique());
            evaluationFormative.put("instrument", dataEvaluationFormative.getInstrument());
            evaluationFormativeData.add(evaluationFormative);
        }

        reportParameters.put("evaluationFormative", new JRBeanCollectionDataSource(evaluationFormativeData));

        List<Map<String, Object>> evaluationFinalData = new ArrayList<>();

        Map<String, Object> evaluationFinal = new HashMap<>();
        for (EvaluationDto dataEvaluationFinal : curso.getEvaluationFinal()) {
            evaluationFinal.put("technique", dataEvaluationFinal.getTechnique());
            evaluationFinal.put("instrument", dataEvaluationFinal.getInstrument());
            evaluationFinalData.add(evaluationFinal);
        }

        reportParameters.put("evaluationFinal", new JRBeanCollectionDataSource(evaluationFinalData));

        List<Map<String, Object>> enviromentData = new ArrayList<>();

        Map<String, Object> enviroment = new HashMap<>();
        for (EnvironmentDto dataEnviroment : curso.getEnviroment()) {
            enviroment.put("technique", dataEnviroment.getInstallation());
            enviroment.put("instrument", dataEnviroment.getPracticalPhase());
            enviroment.put("instrument", dataEnviroment.getTheoreticalPhase());
            enviromentData.add(enviroment);
        }

        reportParameters.put("enviroment", new JRBeanCollectionDataSource(enviromentData));

        reportParameters.put("practiceHours", curso.getPracticeHours());
        reportParameters.put("theoricHours", curso.getTheoricHours());

        List<Map<String, Object>> bibliography = new ArrayList<>();

        for (String cita : curso.getJustify()) {
            Map<String, Object> bibliographydata = new HashMap<>();
            bibliographydata.put("bibliography", cita);
            bibliography.add(bibliographydata);
        }
        reportParameters.put("bibliography", new JRBeanCollectionDataSource(bibliography));

        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:componentsReportDesign/design.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }

    public byte[] exportToXls(Integer id, String type) throws JRException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        SimpleOutputStreamExporterOutput output = new SimpleOutputStreamExporterOutput(byteArray);
        JRXlsExporter exporter = new JRXlsExporter();
        if (type == "need") {
            exporter.setExporterInput(new SimpleExporterInput(getReporteNeed(id)));
        } else {
            exporter.setExporterInput(new SimpleExporterInput(getReporteDesign(id)));
        }
        exporter.setExporterOutput(output);
        exporter.exportReport();
        output.close();
        return byteArray.toByteArray();
    }

    public byte[] exportXls(Integer id, String type) throws JRException {
        return exportToXls(id, type);
    }

}
