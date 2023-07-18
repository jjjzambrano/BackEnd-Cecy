package cecy.cecy_backend.cecy_certificados.links;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinksService {
    @Autowired LinksRepository linksRepository;

    public Links save(Links links){
        return linksRepository.save(links);
    }

    public List<Links> findAll(){
        return linksRepository.findAll();
    }

    public Links findById(Long id){
        return linksRepository.findById(id).orElse(new Links());
    }
    
}