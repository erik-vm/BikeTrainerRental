package erik.vm.bike.trainer.rental.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductImageDTO {

    private UUID imageId;
    private String imageUrl;
    private boolean isMainImage;
}