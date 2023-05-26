package cecy.cecy_backend.cecy_certificados.certificados;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Certificados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // foreing Key de person
    private Long userId;
    // Foreing Key de Curso
    private Long courseId;
    // Foreing Key de Matricula
    private Long tuitionId;
    private String estado;
    private LocalDate fecha;
}
