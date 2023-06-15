

package cecy.cecy_backend.cecy_certificados.estudiantes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.catalogos.CatalogosRepository;
import cecy.cecy_backend.cecy_certificados.catalogos.CatalogosService;

/**
 * EstudiantesService
 */
@Service
public class EstudiantesService {
    @Autowired EstudiantesRepository estudiantesRepository;
    @Autowired CatalogosRepository catalogosRepository;

    public Estudiantes save(Estudiantes entity) {
        entity.getMatriculas().forEach(matricula -> {
            matricula.setEstadoMatricula(catalogosRepository.findFirstByDescripcion(matricula.getEstadoMatricula().getDescripcion()) );         
            matricula.setEstadoCurso(catalogosRepository.findFirstByDescripcion(matricula.getEstadoCurso().getDescripcion()));
            // matricula.getEstudiantes().setMatriculas(null);
    });
        return estudiantesRepository.save(entity);
    }

    public List<Estudiantes> findAll() {
        return estudiantesRepository.findAll();
    }

    public Estudiantes findById(Long id) {
        return estudiantesRepository.findById(id).orElse(new Estudiantes());
    }
}
