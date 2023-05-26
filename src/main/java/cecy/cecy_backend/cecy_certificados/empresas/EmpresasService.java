package cecy.cecy_backend.cecy_certificados.empresas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresasService {
    @Autowired EmpresasRespository empresasRespository;

    public Empresas save(Empresas entity) {
        return empresasRespository.save(entity);
    }

    public List<Empresas> findAll() {
        return empresasRespository.findAll();
    }

    public Empresas findById(Long id) {
        return empresasRespository.findById(id).orElse(new Empresas());
    }
    
}
