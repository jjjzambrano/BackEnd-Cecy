package cecy.cecy_backend.cecy_certificados.asistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AsistenciaRepository extends CrudRepository<Asistencia, Long> {
    List<Asistencia> findAll();
}
