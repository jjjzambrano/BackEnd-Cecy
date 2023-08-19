package cecy.cecy_backend.cecy_certificados.cursos.conexion.reportDto;

import lombok.Data;

@Data
public class ScheduleDto {

    private String endedTime;
    private String startedTime;
    private String days;
    private String workday;

}
