package cecy.cecy_backend.cecy_certificados.cursos;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CustomerDTOCourse {
    private long id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
