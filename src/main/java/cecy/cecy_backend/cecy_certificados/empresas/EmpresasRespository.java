package cecy.cecy_backend.cecy_certificados.empresas;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmpresasRespository extends CrudRepository<Empresas, Long> {
    List<Empresas> findAll();
}
