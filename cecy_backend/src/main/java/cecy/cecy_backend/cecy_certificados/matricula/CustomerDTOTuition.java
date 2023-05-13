package cecy.cecy_backend.cecy_certificados.matricula;

import lombok.Data;

@Data
public class CustomerDTOTuition {
    private long id;
    private long userId;
    private long courseId;
    private String state;

}
