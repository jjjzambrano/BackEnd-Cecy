package cecy.cecy_backend.cecy_certificados.estudiantes;

import java.util.List;
import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EstudiantesRepository extends CrudRepository<Estudiantes, Long> {
    List<Estudiantes> findAll();

    Estudiantes findByCedula(String cedula);
}
