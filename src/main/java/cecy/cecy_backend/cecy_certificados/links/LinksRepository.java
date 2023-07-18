package cecy.cecy_backend.cecy_certificados.links;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LinksRepository extends CrudRepository<Links, Long> {
    List<Links> findAll();
}