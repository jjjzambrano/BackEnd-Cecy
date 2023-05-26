package cecy.cecy_backend.cecy_certificados.catalogos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogosService {
    @Autowired CatalogosRepository catalogosRepository;

    public Catalogos save(Catalogos entity) {
        return catalogosRepository.save(entity);
    }

    public List<Catalogos> findAll() {
        return catalogosRepository.findAll();
    }

    public Catalogos findById(Long id) {
        return catalogosRepository.findById(id).orElse(new Catalogos());
    }
    
}
