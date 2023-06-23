package cecy.cecy_backend.cecy_certificados.tipo_certificado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCertificadoService {
    @Autowired TipoCertificadoRepository entityRepository;

    public TipoCertificado save(TipoCertificado entity){
        return entityRepository.save(entity);
    }

    public TipoCertificado findById( Long id){
        return entityRepository.findById(id).orElse(new TipoCertificado());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<TipoCertificado> findAll(){
        return entityRepository.findAll();
    }
}
