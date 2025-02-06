package erik.vm.bike.trainer.rental.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private UUID productId;
    private String model;
    private String manufacturer;
    private String productCode;
    private Double averageRating;
    private boolean isAvailable;
    private Set<ProductImageDTO> images = new HashSet<>();
}
