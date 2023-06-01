package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import lombok.Data;
@Data
public class Planificacion {
    private Long id;
    private String lectiveYear;
    private String codeCourse;
    private String name;
    private int durationTime;
    private String startDate;
    private String finishDate;
    private String state;
    private Boolean free;
    private int careerId;
    private int roleId;
    private int userId;
    private String createdAt;
}
