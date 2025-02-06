package erik.vm.bike.trainer.rental.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import erik.vm.bike.trainer.rental.model.enums.Discount;
import erik.vm.bike.trainer.rental.model.enums.RentalStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RentalDTO {

    private UUID rentalId;
    private String confirmationCode;
    private UUID userId;
    private UUID productId;
    private UUID productPriceId;
    private int daysOfRental;
    private double totalOfRental;
    private LocalDateTime rentalStarted;
    private LocalDateTime rentalFinished;
    private Discount discount;
    private RentalStatus status;
}
