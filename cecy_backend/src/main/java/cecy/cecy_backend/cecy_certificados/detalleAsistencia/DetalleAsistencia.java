package cecy.cecy_backend.cecy_certificados.detalleAsistencia;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.observaciones.Observaciones;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class DetalleAsistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date dia;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "detalle_asistencia_id")
    private List<Catalogos> estado = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "detalle_asistencia_id")
    private List<Observaciones> observaciones = new ArrayList<>();




    
}
