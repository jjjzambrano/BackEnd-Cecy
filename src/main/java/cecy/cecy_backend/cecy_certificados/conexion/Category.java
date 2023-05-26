package cecy.cecy_backend.cecy_certificados.conexion;

import lombok.Data;

@Data
public class Category {
    private String id;
    private String createdAt;
    private String updatedAt;
    private Object deletedAt;
    private Object parentId;
    private String code;
    private String description;
    private Object icon;
    private String name;
    private String type;
}
