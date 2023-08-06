package cecy.cecy_backend.cecy_certificados.estudiantes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.empresas.Empresas;
import cecy.cecy_backend.cecy_certificados.matriculas.Matriculas;
import cecy.cecy_backend.cecy_certificados.prerequisitos.Prerequisitos;
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
import lombok.Getter;
import lombok.Setter;

// @Data

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Estudiantes.class)
public class Estudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cedula;
    private Date fechaNacimiento;
    private String nombres;
    private String apellidos;
    private String email;
    private Boolean discapacidad;
    private String detallesDiscapacidad;
    private String direccion;
    private String numeroCelular;
    private String numeroConvencional;
    private String clave;

    // @Enumerated(EnumType.STRING)
    // private Role rol;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos genero;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos tipoEstudiante;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos etnia;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos nivelInstruccion;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos situacionEconomica;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Prerequisitos> preRequisitos = new ArrayList<>();

    @ManyToOne()
    private Empresas empresaId;

    // @JsonBackReference
    @OneToMany(mappedBy = "estudiantes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    // @JoinTable(name = "estudiantes_matriculas", joinColumns =
    // {@JoinColumn(name="estudiantes_id")}, inverseJoinColumns =
    // {@JoinColumn(name="matriculas_id")})
    private Set<Matriculas> matriculas = new HashSet<>();

}
