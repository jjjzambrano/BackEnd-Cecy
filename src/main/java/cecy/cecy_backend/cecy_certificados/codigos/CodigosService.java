package cecy.cecy_backend.cecy_certificados.codigos;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class CodigosService {
    @Autowired CodigosRepository entityRepository;

    public Codigos save(Codigos entity){
        return entityRepository.save(entity);
    }

    public Codigos findById( Long id){
        return entityRepository.findById(id).orElse(new Codigos());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<Codigos> findAll(){
        return entityRepository.findAll();
    }

    public Codigos update(Long id, Codigos codigoRequest) {
        Codigos existingCodigos = entityRepository.findById(id).get(); // DB
        existingCodigos.setCodigo(codigoRequest.getCodigo());
        existingCodigos.setMatriculas(codigoRequest.getMatriculas());
        existingCodigos.setCertificado(codigoRequest.getCertificado());
        //if(codigoRequest.getCertificado().getTipoCertificado()== null){
        //}
        return entityRepository.save(existingCodigos);
    }

    public Codigos updateCodigotByFields(Long id, Map<String, Object> fields) {
        Optional<Codigos> existingCodigo = entityRepository.findById(id);

        if (existingCodigo.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Codigos.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingCodigo.get(), value);
            });
            return entityRepository.save(existingCodigo.get());
        }
        return null;
    }
}
