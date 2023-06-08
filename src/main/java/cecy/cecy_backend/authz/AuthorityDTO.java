package cecy.cecy_backend.authz;

import lombok.Data;

@Data
public class AuthorityDTO {
    
    private Long id;
    private String name;
    private String endpoint;

}