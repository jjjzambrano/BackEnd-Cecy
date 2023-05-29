package cecy.cecy_backend.cecy_certificados.matriculas;

import java.util.List;

import org.hibernate.boot.model.source.internal.hbm.ManyToOneAttributeColumnsAndFormulasSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculasService {
    @Autowired MatriculasRepository matriculasRepository;

    public Matriculas save(Matriculas matricula){
        return matriculasRepository.save(matricula);
    }

    public List<Matriculas> findAll(){
        return matriculasRepository.findAll();
    }

    public Matriculas findById(Long id){
        return matriculasRepository.findById(id).orElse(new Matriculas());
    }

    public List<Matriculas> findByEstadoMatricula(String term){
        return matriculasRepository.findByEstadoMatriculaDescripcion(term);
    }
    
}
