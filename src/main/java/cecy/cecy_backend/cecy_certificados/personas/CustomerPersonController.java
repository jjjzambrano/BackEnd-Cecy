package cecy.cecy_backend.cecy_certificados.personas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/persona")
@CrossOrigin({"*"})
public class CustomerPersonController {
    @Autowired CustomerPerson customerPerson;
    @GetMapping("/{id}/")
    public CustomerDTOPerson findById(@PathVariable Long id){
        return customerPerson.findPersonByIdDto(id);
    }
    @GetMapping("/")
    public List<CustomerDTOPerson> findAll(){
        return customerPerson.findPersons();
    }
}
