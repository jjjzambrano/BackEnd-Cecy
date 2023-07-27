package cecy.cecy_backend.cecy_certificados.certificados;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ResourceUtils;

import cecy.cecy_backend.cecy_certificados.codigos.Codigos;
import cecy.cecy_backend.cecy_certificados.codigos.CodigosService;
import cecy.cecy_backend.cecy_certificados.cursos.Curso;
import cecy.cecy_backend.cecy_certificados.cursos.CursoService;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.Course;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.CursoApiFeignService;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.Planificacion;
import cecy.cecy_backend.cecy_certificados.estudiantes.Estudiantes;
import cecy.cecy_backend.cecy_certificados.estudiantes.EstudiantesService;
import cecy.cecy_backend.cecy_certificados.firma.FirmaTipoCertificado;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class CertificadosService {
    @Autowired
    EstudiantesService customerPerson;
    @Autowired
    CursoApiFeignService customerCourse;
    @Autowired
    CertificadosRepository entityRepository;
    @Autowired
    CursoApiFeignService planificationService;
    @Autowired
    CodigosService codigosService;

    public Certificados save(Certificados entity) {
        return entityRepository.save(entity);
    }

    public Certificados findById(Long id) {
        return entityRepository.findById(id).orElse(new Certificados());
    }

    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }

    public List<Certificados> findAll() {
        return entityRepository.findAll();
    }

    public JasperPrint getCertificados(Long id) {
        Map<String, Object> reportParameters = new HashMap<String, Object>();
        Codigos codigos = codigosService.findById(id);
        JasperPrint reportJasperPrint = null;
        String patternStart = "dd, MMMM";
        String patternFinish = "dd, MMMM, yyyy";
        Locale locale = new Locale("es", "EC");
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        if (codigos.getCertificado().getTipoCertificado().getTipo().equals("Cecy")){
            if (codigos.getCertificado().getTipoCertificado().getFirmas().size() == 2) {
                Estudiantes persona = customerPerson.findById(codigos.getMatriculas().getEstudiantes().getId());
                reportParameters.put("nombres_completos", persona.getNombres() + " " + persona.getApellidos());
                Course curso = customerCourse.getCourseById(codigos.getMatriculas().getCursoId().intValue());
                Planificacion planificacion = planificationService.getPlanificationId(curso.getPlanificationId());
                reportParameters.put("curso_nombre", planificacion.getName());
                try {
                    SimpleDateFormat simpleDateFormartStart = new SimpleDateFormat(patternStart,locale);
                   String fechaInicio = simpleDateFormartStart.format(fromUser.parse(planificacion.getStartDate()));
                    SimpleDateFormat simpleDateFormartFinish = new SimpleDateFormat(patternFinish, locale);
                String fechaFin = simpleDateFormartFinish.format(fromUser.parse(planificacion.getFinishDate()));
                reportParameters.put("fecha_curso",fechaInicio + " al " + fechaFin);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                reportParameters.put("hora", Integer.toString(planificacion.getDurationTime()));
                int participanteIndex = 0;
                for (FirmaTipoCertificado participante : codigos.getCertificado().getTipoCertificado().getFirmas()) {
                    if(participanteIndex == 1){
                        reportParameters.put("participante2", participante.getFirma().getNombres() + " " + participante.getFirma().getApellidos());
                        reportParameters.put("tipo_participante2", participante.getRol());
                        reportParameters.put("firma2","classpath:images/"+ participante.getFirma().getFirma());
                        System.out.print("classpath:images/"+ participante.getFirma().getFirma());
                    }
                    if(participanteIndex == 0){
                        participanteIndex = 1;
                        reportParameters.put("participante1", participante.getFirma().getNombres() + " " + participante.getFirma().getApellidos());
                    reportParameters.put("tipo_participante1", participante.getRol());
                    reportParameters.put("firma1","classpath:images/"+ participante.getFirma().getFirma());
                    try {
                        SimpleDateFormat simpleDateFormartStart = new SimpleDateFormat(patternStart,locale);
                       String fechaInicio = simpleDateFormartStart.format(fromUser.parse(planificacion.getStartDate()));
                        SimpleDateFormat simpleDateFormartFinish = new SimpleDateFormat(patternFinish, locale);
                    String fechaFin = simpleDateFormartFinish.format(fromUser.parse(planificacion.getFinishDate()));
                    reportParameters.put("Qr","Nombre Estudiante: "+ persona.getNombres() + " " + persona.getApellidos()+" Nombre del Curso: "+ planificacion.getName() +" Registro Cecy No: "+ codigos.getCodigo()+ " Nombre del Representante Legal: "+participante.getFirma().getNombres()+" Fecha del Curso: "+" del " + fechaInicio + " al "+ fechaFin);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                  ;
                    System.out.print("classpath:images/"+ participante.getFirma().getFirma());
                    }
                    
                }
                String dia = "dd";
                String mes = "MMMM";
                String año = "yyyy";
                Date dateCertificate = java.util.Date.from(codigos.getCertificado().getFecha().atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
                SimpleDateFormat Dateday = new SimpleDateFormat(dia,locale);
                String onlyDay = Dateday.format(dateCertificate);
                SimpleDateFormat DateMonth = new SimpleDateFormat(mes,locale);
                String onlyMonth = DateMonth.format(dateCertificate);
               SimpleDateFormat DateYear = new SimpleDateFormat(año,locale);
               String onlyYear = DateYear.format(dateCertificate);

                reportParameters.put("fecha_certificado", onlyDay + " de "+ onlyMonth+ " de "+ onlyYear);
                reportParameters.put("codigo", codigos.getCodigo());
                
                
               
                try {
                    reportJasperPrint = JasperFillManager.fillReport(
                            JasperCompileManager.compileReport(
                                    ResourceUtils.getFile("classpath:jrxml/cecy_2participantes.jrxml")
                                            .getAbsolutePath()) // path of the jasper report
                            , reportParameters // dynamic parameters
                            , new JREmptyDataSource());
                } catch (FileNotFoundException | JRException e) {
                    e.printStackTrace();
                }

            }
        }
        if (codigos.getCertificado().getTipoCertificado().getTipo().equals("Senecyt")) {

            if (codigos.getCertificado().getTipoCertificado().getFirmas().size() == 2) {
                Estudiantes persona = customerPerson.findById(codigos.getMatriculas().getEstudiantes().getId());
                reportParameters.put("nombres_completos", persona.getNombres() + " " + persona.getApellidos());
                 Course curso = customerCourse.getCourseById(codigos.getMatriculas().getCursoId().intValue());
                Planificacion planificacion = planificationService.getPlanificationId(curso.getPlanificationId());
                reportParameters.put("curso_nombre", planificacion.getName());
                try {
                    SimpleDateFormat simpleDateFormartStart = new SimpleDateFormat(patternStart,locale);
                   String fechaInicio = simpleDateFormartStart.format(fromUser.parse(planificacion.getStartDate()));
                    SimpleDateFormat simpleDateFormartFinish = new SimpleDateFormat(patternFinish, locale);
                String fechaFin = simpleDateFormartFinish.format(fromUser.parse(planificacion.getFinishDate()));
                reportParameters.put("fecha_curso",fechaInicio + " al " + fechaFin);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                reportParameters.put("hora", Integer.toString(planificacion.getDurationTime()));
                int participanteIndex = 0;
                for (FirmaTipoCertificado participante : codigos.getCertificado().getTipoCertificado().getFirmas()) {
                    if(participanteIndex == 1){
                        reportParameters.put("participante2", participante.getFirma().getNombres() + " " + participante.getFirma().getApellidos());
                        reportParameters.put("tipo_participante2", participante.getRol());
                        reportParameters.put("firma2","classpath:images/"+ participante.getFirma().getFirma());
                        System.out.print("classpath:images/"+ participante.getFirma().getFirma());
                    }
                    if(participanteIndex == 0){
                        participanteIndex = 1;
                        reportParameters.put("participante1", participante.getFirma().getNombres() + " " + participante.getFirma().getApellidos());
                    reportParameters.put("tipo_participante1", participante.getRol());
                    reportParameters.put("firma1","classpath:images/"+ participante.getFirma().getFirma());
                    try {
                        SimpleDateFormat simpleDateFormartStart = new SimpleDateFormat(patternStart,locale);
                       String fechaInicio = simpleDateFormartStart.format(fromUser.parse(planificacion.getStartDate()));
                        SimpleDateFormat simpleDateFormartFinish = new SimpleDateFormat(patternFinish, locale);
                    String fechaFin = simpleDateFormartFinish.format(fromUser.parse(planificacion.getFinishDate()));
                    reportParameters.put("Qr","Nombre Estudiante: "+ persona.getNombres() + " " + persona.getApellidos()+" Nombre del Curso: "+ planificacion.getName() +" Registro Senescyt No: "+ codigos.getCodigo()+ " Nombre del Representante Legal: "+participante.getFirma().getNombres()+" Fecha del Curso: "+" del " + fechaInicio + " al "+ fechaFin);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                  ;
                    System.out.print("classpath:images/"+ participante.getFirma().getFirma());
                    }
                    
                }
                String dia = "dd";
                String mes = "MMMM";
                String año = "yyyy";
                Date dateCertificate = java.util.Date.from(codigos.getCertificado().getFecha().atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
                SimpleDateFormat Dateday = new SimpleDateFormat(dia,locale);
                String onlyDay = Dateday.format(dateCertificate);
                SimpleDateFormat DateMonth = new SimpleDateFormat(mes,locale);
                String onlyMonth = DateMonth.format(dateCertificate);
               SimpleDateFormat DateYear = new SimpleDateFormat(año,locale);
               String onlyYear = DateYear.format(dateCertificate);

                reportParameters.put("fecha_certificado", onlyDay + " de "+ onlyMonth+ " de "+ onlyYear);
                reportParameters.put("codigo", codigos.getCodigo());
                
                
               
                try {
                    reportJasperPrint = JasperFillManager.fillReport(
                            JasperCompileManager.compileReport(
                                    ResourceUtils.getFile("classpath:jrxml/senesyt_2participantes.jrxml")
                                            .getAbsolutePath()) // path of the jasper report
                            , reportParameters // dynamic parameters
                            , new JREmptyDataSource());
                } catch (FileNotFoundException | JRException e) {
                    e.printStackTrace();
                }

            }
            

            if (codigos.getCertificado().getTipoCertificado().getFirmas().size() == 3) {
                Estudiantes persona = customerPerson.findById(codigos.getMatriculas().getEstudiantes().getId());
                reportParameters.put("nombres_completos", persona.getNombres() + " " + persona.getApellidos());
                 Course curso = customerCourse.getCourseById(codigos.getMatriculas().getCursoId().intValue());
                Planificacion planificacion = planificationService.getPlanificationId(curso.getPlanificationId());
                reportParameters.put("curso_nombre", planificacion.getName());
                try {
                    SimpleDateFormat simpleDateFormartStart = new SimpleDateFormat(patternStart,locale);
                   String fechaInicio = simpleDateFormartStart.format(fromUser.parse(planificacion.getStartDate()));
                    SimpleDateFormat simpleDateFormartFinish = new SimpleDateFormat(patternFinish, locale);
                String fechaFin = simpleDateFormartFinish.format(fromUser.parse(planificacion.getFinishDate()));
                reportParameters.put("fecha_curso",fechaInicio + " al " + fechaFin);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                reportParameters.put("hora", Integer.toString(planificacion.getDurationTime()));
                int participanteIndex = 0;
                for (FirmaTipoCertificado participante : codigos.getCertificado().getTipoCertificado().getFirmas()) {
                    if(participanteIndex == 2){
                        reportParameters.put("participante3", participante.getFirma().getNombres() + " " + participante.getFirma().getApellidos());
                        reportParameters.put("tipo_participante3", participante.getRol());
                        reportParameters.put("firma3","classpath:images/"+ participante.getFirma().getFirma());
                    }
                    if(participanteIndex == 1){
                        participanteIndex = participanteIndex+1;
                        reportParameters.put("participante2", participante.getFirma().getNombres() + " " + participante.getFirma().getApellidos());
                        reportParameters.put("tipo_participante2", participante.getRol());
                        reportParameters.put("firma2","classpath:images/"+ participante.getFirma().getFirma());
                    }
                    if(participanteIndex == 0){
                        participanteIndex = 1;
                        reportParameters.put("participante1", participante.getFirma().getNombres() + " " + participante.getFirma().getApellidos());
                        reportParameters.put("tipo_participante1", participante.getRol());
                        try {
                            SimpleDateFormat simpleDateFormartStart = new SimpleDateFormat(patternStart,locale);
                           String fechaInicio = simpleDateFormartStart.format(fromUser.parse(planificacion.getStartDate()));
                            SimpleDateFormat simpleDateFormartFinish = new SimpleDateFormat(patternFinish, locale);
                        String fechaFin = simpleDateFormartFinish.format(fromUser.parse(planificacion.getFinishDate()));
                        reportParameters.put("Qr","Nombre Estudiante: "+ persona.getNombres()+ " " + persona.getApellidos()+ " Nombre del Curso: "+ planificacion.getName() +" Registro Senescyt No: "+ codigos.getCodigo()+ " Nombre del Representante Legal: "+participante.getFirma().getNombres()+" Fecha del Curso: "+" del " + fechaInicio + " al "+ fechaFin);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    
                }
                String dia = "dd";
                String mes = "MMMM";
                String año = "yyyy";
                Date dateCertificate = java.util.Date.from(codigos.getCertificado().getFecha().atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
                SimpleDateFormat Dateday = new SimpleDateFormat(dia,locale);
                String onlyDay = Dateday.format(dateCertificate);
                SimpleDateFormat DateMonth = new SimpleDateFormat(mes,locale);
                String onlyMonth = DateMonth.format(dateCertificate);
               SimpleDateFormat DateYear = new SimpleDateFormat(año,locale);
               String onlyYear = DateYear.format(dateCertificate);

                reportParameters.put("fecha_certificado", onlyDay + " de "+ onlyMonth+ " de "+ onlyYear);
                reportParameters.put("codigo", codigos.getCodigo());
                try {
                    reportJasperPrint = JasperFillManager.fillReport(
                            JasperCompileManager.compileReport(
                                    ResourceUtils.getFile("classpath:jrxml/senesyt_3participantes.jrxml")
                                            .getAbsolutePath()) // path of the jasper report
                            , reportParameters // dynamic parameters
                            , new JREmptyDataSource());
                } catch (FileNotFoundException | JRException e) {
                    e.printStackTrace();
                }

            }
        }
        return reportJasperPrint;
    }
}
