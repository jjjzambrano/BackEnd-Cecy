package cecy.cecy_backend.ejecucion_matriculas.asistencias;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AsistenciaRepository extends CrudRepository<Asistencias, Long>{

    List<Asistencias> findAll();

}