package cecy.cecy_backend.cecy_certificados.catalogos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogosService {
    @Autowired
    CatalogosRepository catalogosRepository;

    public Catalogos save(Catalogos entity) {
        return catalogosRepository.save(entity);
    }

    public List<Catalogos> findAll() {
        return catalogosRepository.findAll();
    }

    public Catalogos findById(Long id) {
        return catalogosRepository.findById(id).orElse(new Catalogos());
    }

    public Catalogos findByDescripcion(String term) {
        return catalogosRepository.findByDescripcion(term);
    }

    public Catalogos findFirstByDescription(String term) {
        return catalogosRepository.findFirstByDescripcion(term);
    }

    public List<Catalogos> findByNombre(String term) {
        return catalogosRepository.findByNombre(term);
    }

}
