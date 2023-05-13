package cecy.cecy_backend.cecy_certificados.matricula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/matricula")
@CrossOrigin({ "*" })
public class CustomerTuitionController {
    @Autowired
    CustomerTuition customerTuition;

    @GetMapping("/")
    public List<CustomerDTOTuition> findAll() {
        for (int i = 0; i < customerTuition.findTuition().size(); i = i + 1)
            if ("Reprobado".equals(customerTuition.findTuition().get(i).getState())){
                System.out.print(customerTuition.findTuition());
            }
        return customerTuition.findTuition();
    }

    @GetMapping("/{id}/")
    public CustomerDTOTuition findById(@PathVariable Long id) {
        return customerTuition.findTuitionByIdDto(id);
    }
}

