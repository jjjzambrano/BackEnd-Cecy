package cecy.cecy_backend.cecy_certificados.empresas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/empresas")
@CrossOrigin({ "*" })
public class EmpresasController {

    @Autowired
    EmpresasService empresasService;

    @GetMapping("/")
    public List<Empresas> findAll() {
        return empresasService.findAll();
    }

    @GetMapping("/{id}/")
    public Empresas findById(@PathVariable Long id) {
        return empresasService.findById(id);
    }

    @PostMapping("/")
    public Empresas save(@RequestBody Empresas empresas) {
        return empresasService.save(empresas);
    }
}
