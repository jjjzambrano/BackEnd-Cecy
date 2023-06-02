package cecy.cecy_backend.cecy_certificados.certificados;

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
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/certificado")
@CrossOrigin({"*"})
public class CertificadosController {
   @Autowired CertificadosService certificadosService;

    // @GetMapping("/")
    // public List<Certificados> findAll(){
    //     return certificadosService.findAll();
    // }

    // @GetMapping("/{id}/")
    // public Certificados findById(@PathVariable Long id){
    //     return certificadosService.findById(id);
    // }

    // @PostMapping("/")
    // public Certificados save(@RequestBody Certificados entity){
    //     return certificadosService.save(entity);
    // }

    // @PutMapping("/{id}/")
    // public Certificados update(@RequestBody Certificados entity){
    //     return certificadosService.save(entity);
    // }

    // @DeleteMapping("/{id}/")
    // public void deleteById(@PathVariable Long id){
    //     certificadosService.deleteById(id);
    // }
    // @GetMapping("/pdf/{id}/")
	// public ResponseEntity<byte[]> getCertificadosReporte(@PathVariable long id) throws JRException {

	// 	JasperPrint certificados = certificadosService.getCertificadosReporte(id);
    //     if (certificados==null)
    //         return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);
	// 	HttpHeaders headers = new HttpHeaders();
	// 	// set the PDF format
	// 	headers.setContentType(MediaType.APPLICATION_PDF);
	// 	headers.setContentDispositionFormData("filename", "certificado.pdf");
	// 	// create the report in PDF format
	// 	return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(certificados), headers, HttpStatus.OK);

	}

