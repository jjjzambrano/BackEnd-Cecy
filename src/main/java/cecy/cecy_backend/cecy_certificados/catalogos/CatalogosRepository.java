package cecy.cecy_backend.cecy_certificados.catalogos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CatalogosRepository extends CrudRepository<Catalogos, Long> {
    List<Catalogos> findAll();
    
}
