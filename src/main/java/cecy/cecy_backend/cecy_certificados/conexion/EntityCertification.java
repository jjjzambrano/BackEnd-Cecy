package cecy.cecy_backend.cecy_certificados.conexion;

import lombok.Data;

@Data
public class EntityCertification {
    private String id;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private Integer parentId;
    private String code;
    private String description;
    private String icon;
    private String name;
    private String type;
}
