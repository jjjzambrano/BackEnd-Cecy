package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import lombok.Data;
@Data
public class Planificacion {
    private Integer id;
    private String lectiveYear;
    private String codeCourse;
    private String name;
    private int durationTime;
    private String startDate;
    private String finishDate;
    private String state;
    private Boolean free;
    private Integer careerId;
    private Carrera career;
    private Rol role;
    private Usuario user;
    private String createdAt;
}
