package erik.vm.bike.trainer.rental.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDTO {

    private UUID reviewId;
    private RentalDTO rental;
    private String reviewText;
    private int ratingGrade;
}
