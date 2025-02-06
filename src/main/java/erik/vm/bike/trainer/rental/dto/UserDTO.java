package erik.vm.bike.trainer.rental.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import erik.vm.bike.trainer.rental.model.enums.UserRole;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {


    private UUID userId;
    private String username;
    private UUID personId;
    private UserRole role;

}
