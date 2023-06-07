package cecy.cecy_backend.cecy_certificados.form_inscription;

import java.util.List;

import cecy.cecy_backend.cecy_certificados.catalogos.Catalogos;
import cecy.cecy_backend.cecy_certificados.matriculas.Matriculas;
import cecy.cecy_backend.cecy_certificados.observaciones.Observaciones;
import cecy.cecy_backend.cecy_certificados.prerequisitos.Prerequisitos;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class FormInscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean sponsoredCourse;
    private String institutionContact;

    private String otherCourses;

    @OneToOne(mappedBy = "formInscription")
    private Matriculas matriculas;


    @ManyToOne(cascade = CascadeType.ALL)
    private Catalogos state;

    // foreign key catalogue
    @ManyToOne(cascade = CascadeType.ALL)
    private Catalogos publicity;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "form_inscription_id")
    private List<Prerequisitos> documents;
}

