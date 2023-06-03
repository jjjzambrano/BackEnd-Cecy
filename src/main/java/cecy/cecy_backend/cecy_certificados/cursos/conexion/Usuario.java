package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import lombok.Data;

@Data
public class Usuario {
    private Integer id;
    private String names;
    private String lastnames;
    private String phone;
    private String email;
    private String identityCard;
}
