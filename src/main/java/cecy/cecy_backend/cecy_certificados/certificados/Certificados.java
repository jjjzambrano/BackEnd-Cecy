package cecy.cecy_backend.cecy_certificados.certificados;

import java.time.LocalDate;

import cecy.cecy_backend.cecy_certificados.tipo_certificado.TipoCertificado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Certificados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean estado;
    private LocalDate fecha;
    @ManyToOne
    private TipoCertificado tipoCertificado;
}
