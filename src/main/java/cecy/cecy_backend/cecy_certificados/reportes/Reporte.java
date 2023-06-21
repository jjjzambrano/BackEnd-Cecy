package cecy.cecy_backend.cecy_certificados.reportes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import cecy.cecy_backend.cecy_certificados.codigos.Codigos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaReporte;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "reporte_id")
    private List<Codigos> reportes = new ArrayList<>();
}
