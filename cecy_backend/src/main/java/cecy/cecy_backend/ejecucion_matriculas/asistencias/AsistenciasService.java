package cecy.cecy_backend.ejecucion_matriculas.asistencias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciasService {
    @Autowired AsistenciaRepository asistenciaRepository;

    public Asistencias save(Asistencias entity){
        return asistenciaRepository.save(entity);
    }

    public Asistencias findById( Long id){
        return asistenciaRepository.findById(id).orElse(new Asistencias());
    }

    public void deleteById(Long id){
        asistenciaRepository.deleteById(id);
    }

    public List<Asistencias> findAll(){
        return asistenciaRepository.findAll();
    }

}
