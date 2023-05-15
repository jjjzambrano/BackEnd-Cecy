package cecy.cecy_backend.ejecucion_matriculas.detalleAsistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DetalleAsistenciaService {
    @Autowired DetalleAsistenciaRepository detalleasistenciaRepository;

    public DetalleAsistencia save(DetalleAsistencia entity){
        return detalleasistenciaRepository.save(entity);
    }

    public DetalleAsistencia findById( Long id){
        return detalleasistenciaRepository.findById(id).orElse(new DetalleAsistencia());
    }

    public void deleteById(Long id){
        detalleasistenciaRepository.deleteById(id);
    }

    public List<DetalleAsistencia> findAll(){
        return detalleasistenciaRepository.findAll();
    }

}