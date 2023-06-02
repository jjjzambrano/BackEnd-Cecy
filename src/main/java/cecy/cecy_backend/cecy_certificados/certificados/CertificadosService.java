package cecy.cecy_backend.cecy_certificados.certificados;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ResourceUtils;
/*
import cecy.cecy_backend.cecy_certificados.personas.CustomerDTOPerson;
*/
import cecy.cecy_backend.cecy_certificados.personas.CustomerPerson;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class CertificadosService {
/*    @Autowired
    CustomerPerson customerPerson;
    @Autowired
    CustomerCourse customerCourse;
    @Autowired
    CertificadosRepository entityRepository;

    // public Certificados save(Certificados entity) {
    //     return entityRepository.save(entity);
    // }

    // public Certificados findById(Long id) {
    //     return entityRepository.findById(id).orElse(new Certificados());
    // }

    // public void deleteById(Long id) {
    //     entityRepository.deleteById(id);
    // }

    // public List<Certificados> findAll() {
    //     return entityRepository.findAll();
    // }

    public JasperPrint getCertificadosReporte(Long id) {*/

/*        Map<String, Object> reportParameters = new HashMap<String, Object>();
        Certificados certificados = findById(id);
        if (certificados.getId() == null)
            return null;*/
/*
        CustomerDTOPerson persona = customerPerson.findPersonByIdDto(certificados.getUserId());
*/
       /* reportParameters.put("nombres", persona.getNombres());
        reportParameters.put("apellidos", persona.getApellidos());
        reportParameters.put("rector", persona.getNombres() + " " + persona.getApellidos());
        reportParameters.put("coordinador", persona.getNombres() + " " + persona.getApellidos());*/

/*
        CustomerDTOCourse curso = customerCourse.findCourseByIdDto(certificados.getCourseId());
*/
       /* reportParameters.put("curso_nombre", curso.getNombre());

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
        return reportJasperPrint;*/
/*    }*/
}
