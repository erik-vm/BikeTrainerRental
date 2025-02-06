package erik.vm.bike.trainer.rental.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

    private UUID personId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
