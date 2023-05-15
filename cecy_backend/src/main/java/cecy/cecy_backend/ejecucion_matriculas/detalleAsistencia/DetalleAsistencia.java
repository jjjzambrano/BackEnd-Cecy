package cecy.cecy_backend.ejecucion_matriculas.detalleAsistencia;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import cecy.cecy_backend.ejecucion_matriculas.asistencias.Asistencias;
import lombok.Data;

@Data
@Entity
public class DetalleAsistencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private long personaId;
    @OneToOne()
    @JoinColumn(name = "asistencia_id", referencedColumnName = "id")
    private Asistencias asistenciaId;
    //@OneToOne()
    // @JoinColumn(name = "catalogo_id", referencedColumnName = "id")
    // private Catalogo catalogoId;

 }