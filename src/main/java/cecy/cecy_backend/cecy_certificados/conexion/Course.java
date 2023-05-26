package cecy.cecy_backend.cecy_certificados.conexion;

import lombok.Data;

@Data
public class Course {
    private String id;
    private String image;
    private Number planificationId;
    private Modality modality;
    private Category category;
    private EntityCertification entityCertification;
    private CourseType courseType;
    private CertifiedType certifiedType;
    private FormationType formationType;
    private String abbreviation;
    private Number targetGroups;
    private Number participantTypes;
    private String summary;
    private String project;
    private String objective;
    private String alignment;
    private Area area;
    private Speciality speciality;
    private Number practiceHours;
    private Number theoryHours;
    private Number evaluationMechanisms;
    private Number learningEnvironments;
    private Number teachingStrategies;
    private Number prerequisites;
    private Planification planification;
}
