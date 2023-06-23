package cecy.cecy_backend.cecy_certificados.rol_certificado;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RolCertificadoRepository  extends CrudRepository<RolCertificado, Long> {
    public List<RolCertificado> findAll();
}
