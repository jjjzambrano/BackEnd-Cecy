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

    @Column(name = "planification_id")
    private Integer planificationId;


    private Planificacion planification;

    @Column(name = "modality_id")
    private Integer modalityId;

    private Modalidad modality;


    @Column(name = "category_id")
    private Integer categoryId;

    private Categoria category;


    @Column(name = "entity_certification_id")
    private Integer entityCertificationId;

    private CertificacionEntidad entityCertification;

    @Column(name = "course_type_id")
    private Integer courseTypeId;

    private TipoCurso courseType;

    @Column(name = "certified_type_id")
    private Integer certifiedTypeId;

    private TipoCertificado certifiedType;

    @Column(name = "formation_type_id")
    private Integer formationTypeId;

    private TipoFormacion formationType;

    @Column(name = "area_id")
    private Integer areaId;

    private Area area;

    @Column(name = "speciality_id")
    private Integer specialityId;

    private Especialidad speciality;
}
