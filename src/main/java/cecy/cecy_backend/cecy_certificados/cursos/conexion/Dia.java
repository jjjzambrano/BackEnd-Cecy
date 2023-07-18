package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import lombok.Data;

@Data
public class Dia {
          private Integer id;
          private String name;
          private String type;
          private String icon;
          private String description;
          private String code;
          private String createdAt;
          private Integer parentId;
}
