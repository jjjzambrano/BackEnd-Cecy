package cecy.cecy_backend.cecy_certificados.detalleAsistencia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DetalleAsistenciaRepository extends CrudRepository<DetalleAsistencia, Long> {
    List<DetalleAsistencia> findAll();
}
