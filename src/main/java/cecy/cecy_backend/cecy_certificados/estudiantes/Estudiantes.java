package cecy.cecy_backend.cecy_certificados.estudiantes;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.empresas.Empresas;
import cecy.cecy_backend.cecy_certificados.matriculas.Matriculas;
import cecy.cecy_backend.cecy_certificados.prerequisitos.Prerequisitos;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos genero ;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos tipoEstudiante ;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos etnia ;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos nivelInstruccion ;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos situacionEconomica ;

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
