package erik.vm.bike.trainer.rental.model;

import erik.vm.bike.trainer.rental.model.enums.Discount;
import erik.vm.bike.trainer.rental.model.enums.RentalStatus;
import erik.vm.bike.trainer.rental.model.enums.Tax;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

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

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User rentingUser;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product rentedProduct;

    @ManyToOne
    @JoinColumn(name = "product_price_id")
    private ProductPrice pricePerDay;

    private int daysOfRental;

    @Enumerated(EnumType.STRING)
    private Tax tax;

    @Enumerated(EnumType.STRING)
    private Discount discount;

    private double totalOfRental = (((pricePerDay.getPrice().getPricePerDay() * daysOfRental) * discount.getPresent())) * tax.getTaxPresent();


    private LocalDateTime rentalStarted;
    @Future(message = "value must be in the future!")
    private LocalDateTime rentalFinished;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;


}
