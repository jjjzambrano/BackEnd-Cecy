package cecy.cecy_backend.cecy_certificados.cursos.conexion;

import lombok.Data;

@Data
public class Aula {
  private Integer id;
  private Integer typeId;
  private Integer capacity;
  private String code;
  private String description;
  private String name;
}
