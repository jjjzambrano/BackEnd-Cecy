package cecy.cecy_backend.cecy_certificados.observaciones;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ObservacionesRepository extends CrudRepository<Observaciones, Long> {
    List<Observaciones> findAll();
}
