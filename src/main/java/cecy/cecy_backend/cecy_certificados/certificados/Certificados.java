package cecy.cecy_backend.cecy_certificados.certificados;

import java.time.LocalDate;

import cecy.cecy_backend.cecy_certificados.codigos.Codigos;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Data
@Entity
public class Certificados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean estado;
    private LocalDate fecha;
}
