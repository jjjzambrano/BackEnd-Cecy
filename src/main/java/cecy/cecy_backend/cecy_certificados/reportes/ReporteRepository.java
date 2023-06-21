package cecy.cecy_backend.cecy_certificados.reportes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReporteRepository extends CrudRepository<Reporte, Long>{
    
    public List<Reporte> findAll();
}
