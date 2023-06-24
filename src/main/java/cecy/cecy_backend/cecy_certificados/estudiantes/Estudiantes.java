package cecy.cecy_backend.cecy_certificados.estudiantes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.empresas.Empresas;
import cecy.cecy_backend.cecy_certificados.matriculas.Matriculas;
import cecy.cecy_backend.cecy_certificados.prerequisitos.Prerequisitos;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Matriculas.class)
public class Estudiantes implements UserDetails {
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

    @Enumerated(EnumType.STRING)
    private Role rol;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Catalogos genero;

    @ManyToOne(cascade = CascadeType.ALL)
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

    @OneToMany(mappedBy = "estudiantes", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonManagedReference
    // @JoinTable(name = "estudiantes_matriculas", joinColumns =
    // {@JoinColumn(name="estudiantes_id")}, inverseJoinColumns =
    // {@JoinColumn(name="matriculas_id")})
    private List<Matriculas> matriculas = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return cedula;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
