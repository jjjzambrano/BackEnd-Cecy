package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import lombok.Data;

@Data
public class DetallePlanificacion {
        private Integer id;
        private Integer planificationCourseId;
        private Integer classroomId;
        private Integer dayId;
        private Integer parallelId;
        private Integer workdayId;
        private String endedTime;
        private String observation;
        private String startedTime;
        private Integer instructorId;
        private Aula classroom;
        private Catalogo day;
        private Catalogo parallel;
        private Catalogo workday;
        private Planificacion planificationCourse;
        private Usuario instructor;
}
