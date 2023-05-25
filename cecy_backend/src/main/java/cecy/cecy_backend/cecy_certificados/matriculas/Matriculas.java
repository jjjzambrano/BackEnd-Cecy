package cecy.cecy_backend.cecy_certificados.matriculas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import cecy.cecy_backend.cecy_certificados.asistencia.Asistencia;
import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.observaciones.Observaciones;
import lombok.Data;



@Data
@Entity
public class Matriculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float nota1;
    private Float nota2;
    private Float promedio;
    private Float porcentajeAsistencia;

    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "matriculas_id")
    private List<Observaciones> observaciones = new ArrayList<>();

    // con observaciones - rechazado - aceptado
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "matriculas_id")
    private List<Catalogos> estadoMatricula = new ArrayList<>();

    // aprobado - reprobado
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "matriculas_id")
    private List<Catalogos> estadoCurso = new ArrayList<>();

    // asistencias

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "matriculas_id")
    private List<Asistencia> asistencias = new ArrayList<>();
}
