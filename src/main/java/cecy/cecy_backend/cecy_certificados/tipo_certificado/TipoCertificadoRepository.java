package cecy.cecy_backend.cecy_certificados.tipo_certificado;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TipoCertificadoRepository extends CrudRepository<TipoCertificado, Long> {
    
    public List<TipoCertificado> findAll();
}
