package erik.vm.bike.trainer.rental.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "product_prices")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_price_id")
    private UUID productPriceId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "price_id", nullable = false)
    private Price price;


    private LocalDateTime started;
    private LocalDateTime finished;

}
