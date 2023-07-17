package cecy.cecy_backend.cecy_certificados.matriculas;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import cecy.cecy_backend.cecy_certificados.asistencia.Asistencia;
import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.estudiantes.Estudiantes;
import cecy.cecy_backend.cecy_certificados.observaciones.Observaciones;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;



@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Matriculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cursoId;
    private Float nota1;
    private Float nota2;
    private Float promedio;
    private Float porcentajeAsistencia;

    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "matriculas_id")
    private List<Observaciones> observaciones = new ArrayList<>();

    // con observaciones - rechazado - aceptado
    @ManyToOne(cascade = CascadeType.ALL)
    private Catalogos estadoMatricula;

    // aprobado - reprobado
    @ManyToOne(cascade = CascadeType.ALL)
    private Catalogos estadoCurso;

    // asistencias

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name = "matriculas_id")
    // private List<Asistencia> asistencias = new ArrayList<>();

    // estudiante
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiantes_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    // @JsonBackReference
    // @JsonProperty(access  = JsonProperty.Access.READ_ONLY)
    Estudiantes estudiantes;
}
