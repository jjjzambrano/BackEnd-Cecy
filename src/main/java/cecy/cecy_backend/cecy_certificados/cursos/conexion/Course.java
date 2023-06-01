package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Course {
    private Integer id;

    private String abbreviation;
    private Long targetGroups;
    private Long participantTypes;
    private String summary;
    private String project;
    private String objective;
    private String alignment;
    private String image;

    private Long practiceHours;
    private Long theoryHours;
    private Long evaluationMechanisms;
    private Long learningEnvironments;
    private Long teachingStrategies;
    private Long prerequisites;

    private Integer planificationId;
    private Planificacion planification;
    private Integer modalityId;
    private Modalidad modality;
    private Integer categoryId;
    private Categoria category;
    private Integer entityCertificationId;
    private CertificacionEntidad entityCertification;
    private Integer courseTypeId;
    private TipoCurso courseType;
    private Integer certifiedTypeId;
    private TipoCertificado certifiedType;
    private Integer formationTypeId;
    private TipoFormacion formationType;
    private Integer areaId;
    private Area area;
    private Integer specialityId;
    private Especialidad speciality;
}
