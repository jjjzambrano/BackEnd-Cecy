package cecy.cecy_backend.cecy_certificados.cursos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class CursoService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired CursoRepository cursoRepository;

    /*Ver todos los cursos*/
    public List<Curso> getCourseAll() {
        return cursoRepository.findAll();
    }

    /*Busqueda por Id*/
    public Curso findById(long id) {
        return cursoRepository.findById(id).orElse(new Curso());
    }

    /*Actualizar el curso*/
    public Curso updateById(Curso curso){
        return cursoRepository.save(curso);
    }

}
