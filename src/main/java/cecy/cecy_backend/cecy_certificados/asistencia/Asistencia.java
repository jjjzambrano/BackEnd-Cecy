package cecy.cecy_backend.cecy_certificados.asistencia;

import java.sql.Date;
import java.util.List;

import cecy.cecy_backend.cecy_certificados.detalleAsistencia.DetalleAsistencia;
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
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String periodo;
    private Integer cursoId;
    private String evidenciaFotografica;
    private String duracionClase;
    private Date fecha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "asistencia_id")
    private List<DetalleAsistencia> detalleAsistencia;
}