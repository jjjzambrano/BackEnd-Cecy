package cecy.cecy_backend.cecy_certificados.rol_certificado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class RolCertificadoPersona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String nombres;
   private String apellidos;
   private String dni;
   @ManyToOne
   private RolCertificado rol;
}
