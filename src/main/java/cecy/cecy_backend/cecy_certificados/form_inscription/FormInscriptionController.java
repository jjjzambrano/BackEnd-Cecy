package cecy.cecy_backend.cecy_certificados.form_inscription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/formInscription")
@CrossOrigin({ "*" })
public class FormInscriptionController {

    @Autowired
    FormInscriptionService formInscriptionService;

    @GetMapping("/")
    public List<FormInscription> findAll() {
        return formInscriptionService.findAll();
    }

    @GetMapping("/{id}/")
    public FormInscription findById(@PathVariable Long id) {
        return formInscriptionService.findById(id);
    }

    @PostMapping("/")
    public FormInscription save(@RequestBody FormInscription formInscription) {
        return formInscriptionService.save(formInscription);
    }
}

