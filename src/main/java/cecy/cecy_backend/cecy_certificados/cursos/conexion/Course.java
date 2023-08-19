package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Course {

    // public enum EstadosCurso {
    //     aprobado,
    //     cerrado,
    //     terminado
    // }


    private Integer id;

    private String abbreviation;
    /*private GruposDestinados targetGroups;*/

    private Long participantTypes;
    private String summary;
    private String project;
    private String objective;
    private String alignment;
    private String image;

    private Long practiceHours;
    private Long theoryHours;
    /*private Long evaluationMechanisms;*//*ESTE CAMPO ES DE TIPO ARRAY*/
    /*private Long learningEnvironments;*/
    /*private Long teachingStrategies;*/ /*ESTE CAMPO ES DE TIPO ARRAY*/
    /*private Long prerequisites;*/  /*ESTE CAMPO ES DE TIPO ARRAY*/


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
    // private EstadosCurso state;

}
