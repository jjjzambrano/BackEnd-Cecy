package cecy.cecy_backend.cecy_certificados.certificados_generados;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CertificadosGeneradosRepository extends CrudRepository<CertificadosGenerados, Long> {

    public List<CertificadosGenerados> findAll();
}
