package erik.vm.bike.trainer.rental.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "username cant be blank")
    private String username;
    @NotBlank(message = "password cant be blank")
    private String password;
}
