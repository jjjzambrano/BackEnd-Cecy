package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import lombok.Data;

@Data
public class Rol {
    private Integer id;
    private String name;
    private String description;
    private String createdAt;
    private String updateAt;
}
