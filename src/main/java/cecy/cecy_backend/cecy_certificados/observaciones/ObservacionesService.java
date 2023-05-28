package cecy.cecy_backend.cecy_certificados.observaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservacionesService {
    @Autowired ObservacionesRepository observacionesRepository;

    public Observaciones save(Observaciones observaciones){
        return observacionesRepository.save(observaciones);
    }

    public List<Observaciones> findAll(){
        return observacionesRepository.findAll();
    }

    public Observaciones findById(Long id){
        return observacionesRepository.findById(id).orElse(new Observaciones());
    }
    
}
