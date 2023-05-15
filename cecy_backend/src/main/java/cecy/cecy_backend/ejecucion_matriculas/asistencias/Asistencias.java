package cecy.cecy_backend.ejecucion_matriculas.asistencias;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Asistencias {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String periodo;
    private long cursoId;
    private Date fecha;

 }
