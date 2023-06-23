package cecy.cecy_backend.cecy_certificados.estudiantes;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

public interface EstudiantesRepository extends JpaRepository<Estudiantes, Long>  {
    List<Estudiantes> findAll();
    
    Optional<Estudiantes>  findByCedula(String cedula);
}
