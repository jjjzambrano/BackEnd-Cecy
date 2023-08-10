package cecy.cecy_backend.cecy_certificados.codigos;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import cecy.cecy_backend.cecy_certificados.certificados.Certificados;
import cecy.cecy_backend.cecy_certificados.matriculas.Matriculas;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Codigos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;

    @ManyToOne
    private Matriculas matriculas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificado_id", referencedColumnName = "id")
    Certificados certificado;
}
