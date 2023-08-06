package cecy.cecy_backend.cecy_certificados.matriculas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.boot.model.source.internal.hbm.ManyToOneAttributeColumnsAndFormulasSource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.estudiantes.Estudiantes;
import cecy.cecy_backend.cecy_certificados.form_inscription.FormInscription;
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
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Matriculas.class)
@Getter
@Setter
public class Matriculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cursoId;
    private String cursoNombre;
    private Float nota1;
    private Float nota2;
    private Float promedio;
    private Float porcentajeAsistencia;


    // con observaciones - rechazado - aceptado
    @OneToMany(cascade = CascadeType.ALL)
    private List<Observaciones> observaciones = new ArrayList<>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Catalogos estadoMatricula;

    // aprobado - reprobado
    @ManyToOne(cascade = CascadeType.ALL)
    // @ManyToOne()
    private Catalogos estadoCurso;

    // asistencias

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name = "matriculas_id")
    // private List<Asistencia> asistencias = new ArrayList<>();

    // estudiante
    // @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    // @ManyToOne()

    @JoinColumn(name = "estudiantes_id", referencedColumnName = "id")
    // @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

    // @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Estudiantes estudiantes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "form_inscription_id", referencedColumnName = "id")
    FormInscription formInscription;
}
