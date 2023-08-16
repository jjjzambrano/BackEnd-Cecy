package cecy.cecy_backend.cecy_certificados.cursos.conexion.reportDto;
import java.util.List;

import lombok.Data;

@Data
public class CourseReportDto {
    private Integer id;
    private String codeCourse;
    private String teacher;
    private String nameCourse;
    private String type;
    private String modality;
    private List<String> justify;
    private List<ScheduleDto> schedule;
    private String duration;
    private String startedDate;
    private String endedDate;
    private String participantRegister;
    private String summary;
    private String project;
    private String participantTypes;

    private String area;
    private String speciality;
    private String requireTechnique;
    private String requireGeneral;
    private String object;
    private String strategy;
    private List<EvaluationDto> evaluationDiagnostic;
    private List<EvaluationDto> evaluationFormative;
    private List<EvaluationDto> evaluationFinal;
    private List<EnvironmentDto> enviroment;
    private String practiceHours;
    private String theoricHours;
    private List<String> bibliography;

    // Constructor, getters y setters para los campos

}
