package cecy.cecy_backend.cecy_certificados.asistencia;

import java.sql.Date;
import java.util.List;


import cecy.cecy_backend.cecy_certificados.links.Links;
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
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cursoId;
    private String evidenciaFotografica;
    private Date fecha;
    // private Float porcentajeAsistencia;
    // private String observacion;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "asistencia_id")
    // private List<DetalleAsistencia> detalleAsistencia;

     @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "asistencia_id")
    private List<Observaciones> observaciones; 

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "asistencia_id")
    private List<Links> links;
}