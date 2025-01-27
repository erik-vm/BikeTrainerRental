package erik.vm.bike.trainer.rental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID productId;

    @NotNull
    @Size(min = 1, max = 100)
    private String model;

    @NotNull
    @Size(min = 1, max = 100)
    private String manufacturer;

    @NotNull
    @Size(min = 1, max = 50)
    private String productCode;

    @Min(0)
    @Max(5)
    private Double averageRating;

    private boolean isAvailable;

    @OneToMany(mappedBy = "rentedProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Rental> rentals = new HashSet<>();
}

