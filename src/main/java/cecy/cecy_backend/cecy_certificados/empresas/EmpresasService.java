package cecy.cecy_backend.cecy_certificados.empresas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresasService {
    @Autowired EmpresasRepository empresasRepository;

    public Empresas save(Empresas entity) {
        return empresasRepository.save(entity);
    }

    public List<Empresas> findAll() {
        return empresasRepository.findAll();
    }

    public Empresas findById(Long id) {
        return empresasRepository.findById(id).orElse(new Empresas());
    }
    
}
