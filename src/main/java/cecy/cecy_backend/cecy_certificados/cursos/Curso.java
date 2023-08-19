package cecy.cecy_backend.cecy_certificados.cursos;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "courses")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String abbreviation;
/*    private Integer targetGroups;*/
    private Integer participantTypes;
    private String summary;
    private String project;
    private String objective;
    private String alignment;
    private String image;

    private Integer practiceHours;
    private Integer theoryHours;
    private Integer evaluationMechanisms;

   /* @JsonAlias("learningEnvironments")
    private JsonNode learningEnvironments;*/

/*
    private Integer teachingStrategies;
*/
    /*private Integer prerequisites;*/

    @Column(name = "planification_id")
    private Integer planificationId;

    @Column(name = "modality_id")
    private Integer modalityId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "entity_certification_id")
    private Integer entityCertificationId;

    @Column(name = "course_type_id")
    private Integer courseTypeId;

    @Column(name = "certified_type_id")
    private Integer certifiedTypeId;

    @Column(name = "formation_type_id")
    private Integer formationTypeId;

    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "speciality_id")
    private Integer specialityId;

    /*PUEDEN AGREGAR SUS RELACIONES Y CAMPOS A ESTE MODELO MAPEADO DIRECTO ALA TABLA courses*/
    /*----------------------------------------------------------------*/

    public enum EstadosCurso {
        aprobado,
        cerrado
    }

    @Column(name = "status_course")
    private EstadosCurso statusCourse;
    
    /*INICIO DATOS DE PRUEBA PUEDEN BORRARLO SI NO LO VEN NECESARIO*/
    @Column(name = "matricula_id")
    private Integer matriculaId;

    @Column(name = "estudiantes_id")
    private Integer estudiantesId;

    @Column(name = "notas_id")
    private Integer notasId;

    /*FIN DATOS DE PRUEBA*/
}
