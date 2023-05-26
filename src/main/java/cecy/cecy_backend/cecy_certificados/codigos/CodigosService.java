package cecy.cecy_backend.cecy_certificados.codigos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodigosService {
    @Autowired CodigosRepository entityRepository;

    public Codigos save(Codigos entity){
        return entityRepository.save(entity);
    }

    public Codigos findById( Long id){
        return entityRepository.findById(id).orElse(new Codigos());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<Codigos> findAll(){
        return entityRepository.findAll();
    }
}
