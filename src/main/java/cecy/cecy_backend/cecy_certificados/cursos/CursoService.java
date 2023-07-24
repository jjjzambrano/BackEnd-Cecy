package cecy.cecy_backend.cecy_certificados.cursos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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

    /*Agregar nueva informacion en sus campos nuevos*/

    public Curso create(Curso curso) {
        return  cursoRepository.save(curso);
    }

    /*Actualizar el curso por id*/
    public Curso updateById(Integer id,  Curso cursodto){
        Curso curso = cursoRepository.findById(id.longValue()).orElseThrow(() -> new NoSuchElementException("No se encontró el curso con el ID: " + id));
        BeanUtils.copyProperties(cursodto, curso, "id");
        return cursoRepository.save(curso);
    }

}
