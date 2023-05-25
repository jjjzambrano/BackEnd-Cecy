package cecy.cecy_backend.cecy_certificados.asistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.detalleAsistencia.DetalleAsistencia;
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
