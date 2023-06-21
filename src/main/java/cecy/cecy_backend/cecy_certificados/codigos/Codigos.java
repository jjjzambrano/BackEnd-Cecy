package cecy.cecy_backend.cecy_certificados.codigos;

import cecy.cecy_backend.cecy_certificados.matriculas.Matriculas;
import cecy.cecy_backend.cecy_certificados.reportes.Reporte;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Codigos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    @ManyToOne
    private Matriculas matriculas;
}
