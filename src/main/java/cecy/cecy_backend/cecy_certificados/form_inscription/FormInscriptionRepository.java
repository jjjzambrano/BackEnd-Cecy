package cecy.cecy_backend.cecy_certificados.form_inscription;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FormInscriptionRepository extends CrudRepository<FormInscription, Long> {
    public List<FormInscription> findAll();
    
}
