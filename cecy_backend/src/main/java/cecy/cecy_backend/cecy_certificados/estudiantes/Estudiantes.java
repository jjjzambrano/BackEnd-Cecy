package cecy.cecy_backend.cecy_certificados.estudiantes;
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

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.empresas.Empresas;
import cecy.cecy_backend.cecy_certificados.matriculas.Matriculas;
import cecy.cecy_backend.cecy_certificados.prerequisitos.Prerequisitos;
import lombok.Data;



@Data
@Entity
public class Estudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private Date fechaNacimiento;
    private String nombres;
    private String apellidos;
    private String email;
    private Boolean discapacidad; 
    private String detallesDiscapacidad;
    private String direccion;
    private String numeroCelular;
    private String numeroConvencional;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Catalogos> genero = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Catalogos> tipoEstudiante = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Catalogos> etnia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Catalogos> nivelInstruccion = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Catalogos> situacionEconomica = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Prerequisitos> preRequisitos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Empresas> empresas = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "estudiantes_id")
    private List<Matriculas> matriculas = new ArrayList<>();


}
