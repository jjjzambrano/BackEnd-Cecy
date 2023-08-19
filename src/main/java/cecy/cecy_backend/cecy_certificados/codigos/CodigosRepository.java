package cecy.cecy_backend.cecy_certificados.codigos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CodigosRepository extends CrudRepository<Codigos, Long> {
     
    public List<Codigos> findAll();

    public Codigos findFirstByMatriculasId(int id);
}
