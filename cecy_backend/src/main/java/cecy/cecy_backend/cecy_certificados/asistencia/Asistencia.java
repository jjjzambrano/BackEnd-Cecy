package cecy.cecy_backend.cecy_certificados.asistencia;

import java.util.ArrayList;
import java.util.List;

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.detalleAsistencia.DetalleAsistencia;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    // presente - ausente - atrasado
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "asistencia_id")
    private List<Catalogos> estado = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_asistencia_id", referencedColumnName = "id")
    private DetalleAsistencia detalleAsistencia;

}
