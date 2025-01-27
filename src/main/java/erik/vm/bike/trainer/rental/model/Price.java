package erik.vm.bike.trainer.rental.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "price_id")
    private UUID priceId;

    private double pricePerDay;

    @OneToMany(mappedBy = "price")
    private Set<ProductPrice> productPrices = new HashSet<>();
}
