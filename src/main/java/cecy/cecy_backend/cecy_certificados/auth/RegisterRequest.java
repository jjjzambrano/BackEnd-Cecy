package cecy.cecy_backend.cecy_certificados.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nombres;
    private String apellidos;
    private String cedula;
    private String clave;
}
