package cecy.cecy_backend.cecy_certificados.prerequisitos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrerequisitosService {
    @Autowired
    PrerequisitosRepository prerequisitosRepository;

    public Prerequisitos save(Prerequisitos entity) {
        return prerequisitosRepository.save(entity);
    }

    public List<Prerequisitos> findAll() {
        return prerequisitosRepository.findAll();
    }

    public Prerequisitos findById(Long id) {
        return prerequisitosRepository.findById(id).orElse(new Prerequisitos());
    }
}
