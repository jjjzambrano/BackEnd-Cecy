package cecy.cecy_backend.cecy_certificados.empresas;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmpresasRepository extends CrudRepository<Empresas, Long> {
    public List<Empresas> findAll();
}
