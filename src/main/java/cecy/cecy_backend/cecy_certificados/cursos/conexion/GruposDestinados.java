package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import lombok.Data;

@Data
public class GruposDestinados {
	private Integer id;
    private String name;
    private String description;
    private String code;
    private String icon;
    private String type;
    private Integer parentId;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
