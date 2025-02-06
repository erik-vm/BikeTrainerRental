package erik.vm.bike.trainer.rental.model;

import erik.vm.bike.trainer.rental.model.enums.Discount;
import erik.vm.bike.trainer.rental.model.enums.RentalStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    @NotNull
    @Column(name = "confirmation_code", unique = true)
    private String confirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User rentingUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product rentedProduct;

    @ManyToOne
    @JoinColumn(name = "product_price_id", nullable = true)
    private ProductPrice pricePerDay;

    private int daysOfRental;

    @Enumerated(EnumType.STRING)
    private Discount discount;

    private LocalDateTime rentalStarted;

    @Future(message = "Rental must finish in the future!")
    private LocalDateTime rentalFinished;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    public double calculateTotalOfRental() {
        if (pricePerDay != null && discount != null) {
            return (pricePerDay.getPrice().getPricePerDay() * daysOfRental) * (1 - discount.getPresent());
        }
        return 0;
    }
}
