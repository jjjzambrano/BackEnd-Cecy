package cecy.cecy_backend.cecy_certificados.matriculas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cecy.cecy_backend.cecy_certificados.catalogos.CatalogosRepository;

@Service
public class MatriculasService {
    @Autowired
    MatriculasRepository matriculasRepository;
    @Autowired
    CatalogosRepository catalogosRepository;

    public Matriculas save(Matriculas matricula) {
        matricula.setEstadoMatricula(
                catalogosRepository.findFirstByDescripcion(matricula.getEstadoMatricula().getDescripcion()));
        matricula.setEstadoCurso(
                catalogosRepository.findFirstByDescripcion(matricula.getEstadoCurso().getDescripcion()));
        // matricula.getEstudiantes().setMatriculas(null);
        return matriculasRepository.save(matricula);
    }

    public List<Matriculas> findAll() {
        return matriculasRepository.findAll();
    }

    public Matriculas findById(Long id) {
        return matriculasRepository.findById(id).orElse(new Matriculas());
    }

    public List<Matriculas> findByEstadoMatricula(String term) {
        return matriculasRepository.findByEstadoMatriculaDescripcion(term);
    }

    public List<Matriculas> findByCursoId(int id) {
        return matriculasRepository.findByCursoId(id);
    }

    public List<Matriculas> findByEstadoCurso(String term) {
        return matriculasRepository.findByEstadoCursoDescripcion(term);
    }
}
