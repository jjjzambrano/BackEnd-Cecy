package cecy.cecy_backend.ejecucion_matriculas.detalleAsistencia;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DetalleAsistenciaRepository extends CrudRepository<DetalleAsistencia, Long>{

    List<DetalleAsistencia> findAll();

}