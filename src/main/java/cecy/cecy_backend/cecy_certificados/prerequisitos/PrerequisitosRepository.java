package cecy.cecy_backend.cecy_certificados.prerequisitos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PrerequisitosRepository extends CrudRepository<Prerequisitos, Long> {
    List<Prerequisitos> findAll();
    
}
