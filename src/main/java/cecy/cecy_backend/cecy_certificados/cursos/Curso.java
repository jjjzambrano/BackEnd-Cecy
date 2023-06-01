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

    /*INICIO DATOS DE PRUEBA PUEDEN BORRARLO SI NO LO VEN NECESARIO*/
    @Column(name = "matricula_id")
    private Integer matriculaId;

    @Column(name = "estudiantes_id")
    private Integer estudiantesId;

    @Column(name = "notas_id")
    private Integer notasId;

    /*FIN DATOS DE PRUEBA*/

}
