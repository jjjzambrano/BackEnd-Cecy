package cecy.cecy_backend.cecy_certificados.certificados;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ResourceUtils;

import cecy.cecy_backend.cecy_certificados.codigos.Codigos;
import cecy.cecy_backend.cecy_certificados.codigos.CodigosService;
import cecy.cecy_backend.cecy_certificados.cursos.Curso;
import cecy.cecy_backend.cecy_certificados.cursos.CursoService;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.CursoApiFeignService;
import cecy.cecy_backend.cecy_certificados.cursos.conexion.Planificacion;
import cecy.cecy_backend.cecy_certificados.estudiantes.Estudiantes;
import cecy.cecy_backend.cecy_certificados.estudiantes.EstudiantesService;
import cecy.cecy_backend.cecy_certificados.rol_certificado.RolCertificadoPersona;
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
    CursoService customerCourse;
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
       for(RolCertificadoPersona personas: codigos.getCertificado().getTipoCertificado().getRoles()){
        if(personas.getRol().getName().equals("Rector")){
            reportParameters.put("rector", personas.getNombres()+ " " + personas.getApellidos() );
        }
       if(personas.getRol().getName().equals("Coordinador Cecy")){
        reportParameters.put("coordinador", personas.getNombres()+ " " + personas.getApellidos() );
       }
       };
        if (codigos.getId() == null)
            return null;
        Estudiantes persona = customerPerson.findById(codigos.getMatriculas().getEstudiantes().getId());
        reportParameters.put("nombres_completos", persona.getNombres()+ " " + persona.getApellidos());
       Curso curso = customerCourse.findById(codigos.getMatriculas().getCursoId());
       Planificacion planificacion =   planificationService.getPlanificationId(curso.getPlanificationId());
        reportParameters.put("curso_nombre", planificacion.getName());

        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:jrxml/Certificado.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }
}
