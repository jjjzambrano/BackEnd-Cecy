package cecy.cecy_backend.cecy_certificados.cursos;

import java.util.List;

import javax.persistence.GenerationType;

import org.hibernate.annotations.CascadeType;

import cecy.cecy_backend.cecy_certificados.matriculas.Matriculas;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Curso {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "courses_id")
    private List<Matriculas> matriculas;

}
