package cecy.cecy_backend.cecy_certificados.firma;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FirmasService {
    @Autowired FirmasRepository entityRepository;

    public Firmas save(Firmas entity){
        return entityRepository.save(entity);
    }

    public Firmas findById( Long id){
        return entityRepository.findById(id).orElse(new Firmas());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<Firmas> findAll(){
        return entityRepository.findAll();
    }
}
