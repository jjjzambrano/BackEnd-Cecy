package cecy.cecy_backend.cecy_certificados.estudiantes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudiantesService {
    @Autowired
    EstudiantesRepository estudiantesRepository;

    public Estudiantes save(Estudiantes entity) {
        return estudiantesRepository.save(entity);
    }

    public List<Estudiantes> findAll() {
        return estudiantesRepository.findAll();
    }

    public Estudiantes findById(Long id) {
        return estudiantesRepository.findById(id).orElse(new Estudiantes());
    }
}
