package cecy.cecy_backend.cecy_certificados.asistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaService {

    @Autowired AsistenciaRepository asistenciaRepository; 

    public List<Asistencia> findAll(){
        return asistenciaRepository.findAll();
    }

    public Asistencia findById(Long id){
        return asistenciaRepository.findById(id).orElse(new Asistencia());
    }

    public Asistencia save(Asistencia asistencia){
        return asistenciaRepository.save(asistencia);
    }
}
