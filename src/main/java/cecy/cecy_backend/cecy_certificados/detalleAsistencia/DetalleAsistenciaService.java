package cecy.cecy_backend.cecy_certificados.detalleAsistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleAsistenciaService {

    @Autowired DetalleAsistenciaRepository detalleAsistenciaRepository;

    public DetalleAsistencia save(DetalleAsistencia entity) {
        return detalleAsistenciaRepository.save(entity);
    }

    public List<DetalleAsistencia> findAll() {
        return detalleAsistenciaRepository.findAll(); 
    }

    public DetalleAsistencia findById(Long id) {
        return detalleAsistenciaRepository.findById(id).orElse(new DetalleAsistencia());
    }
    
}
