package cecy.cecy_backend.cecy_certificados.prerequisitos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrerequisitosService {

    @Autowired PrerequisitosRepository prerequisitosRepository;

    public List<Prerequisitos> findAll() {
        return prerequisitosRepository.findAll();
    }

    public Prerequisitos findById(Long id) {
        return prerequisitosRepository.findById(id).orElse(new Prerequisitos());
    }

    public Prerequisitos save(Prerequisitos prerequisitos) {
        return prerequisitosRepository.save(prerequisitos);
    }
    
}
