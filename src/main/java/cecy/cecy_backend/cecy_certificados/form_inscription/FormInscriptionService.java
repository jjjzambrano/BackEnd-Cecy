package cecy.cecy_backend.cecy_certificados.form_inscription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormInscriptionService {
    @Autowired
    FormInscriptionRepository formInscriptionRepository;

    public FormInscription save(FormInscription entity) {
        return formInscriptionRepository.save(entity);
    }

    public List<FormInscription> findAll() {
        return formInscriptionRepository.findAll();
    }

    public FormInscription findById(Long id) {
        return formInscriptionRepository.findById(id).orElse(new FormInscription());
    }
}
