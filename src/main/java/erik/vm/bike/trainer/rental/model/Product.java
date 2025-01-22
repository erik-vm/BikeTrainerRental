package erik.vm.bike.trainer.rental.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID itemId;
    private String model;
    private String manufacturer;
    private String productCode;
    private Double averageRating;
    private boolean isAvailable;


    @OneToMany
    private List<Rental> rentals = new ArrayList<>();

}
