package erik.vm.bike.trainer.rental.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "rental_id")
    private UUID rentalId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product rentedProduct;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User rentingUser;

    private LocalDateTime rentalStarted;
    private LocalDateTime rentalFinished;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;



}
