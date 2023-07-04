package cecy.cecy_backend.cecy_certificados.tipo_certificado;

import java.util.ArrayList;
import java.util.List;

import cecy.cecy_backend.cecy_certificados.firma.FirmaTipoCertificado;

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
public class TipoCertificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tipo_certificado_id")
    private List<FirmaTipoCertificado> firmas = new ArrayList<>();
}
