package cecy.cecy_backend.cecy_certificados.firma;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FirmasRepository extends CrudRepository<Firmas, Long>  {
    
    public List<Firmas> findAll();
}

