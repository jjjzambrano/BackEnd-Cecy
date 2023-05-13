package cecy.cecy_backend.cecy_certificados.certificados_generados;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificadosGeneradosService {

    @Autowired CertificadosGeneradosRepository entityRepository;

    public CertificadosGenerados save(CertificadosGenerados entity){
        return entityRepository.save(entity);
    }

    public CertificadosGenerados findById( Long id){
        return entityRepository.findById(id).orElse(new CertificadosGenerados());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<CertificadosGenerados> findAll(){
        return entityRepository.findAll();
    }
}