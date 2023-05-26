package cecy.cecy_backend.cecy_certificados.matricula;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "bff.customer-tuition", url = "http://localhost:8092/api/formInscription")
public interface CustomerTuition {
    @GetMapping("/{id}/")
    CustomerDTOTuition findTuitionByIdDto(@PathVariable("id") Long id);
   
    @GetMapping("/")
    List<CustomerDTOTuition> findTuition();
}
