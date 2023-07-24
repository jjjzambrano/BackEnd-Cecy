package cecy.cecy_backend.cecy_certificados.cursos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoRepository extends CrudRepository<Curso, Long> {
    List<Curso> findAll();
}
