package cecy.cecy_backend.cecy_certificados.rol_certificado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolCertificadoService {
    @Autowired RolCertificadoRepository entityRepository;
    public RolCertificado save(RolCertificado entity){
        return entityRepository.save(entity);
    }

    public RolCertificado findById( Long id){
        return entityRepository.findById(id).orElse(new RolCertificado());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<RolCertificado> findAll(){
        return entityRepository.findAll();
    }
}
