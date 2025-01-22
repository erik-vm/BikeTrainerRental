package erik.vm.bike.trainer.rental.model;

import jakarta.persistence.*;
import lombok.Data;
import org.joda.time.DateTime;

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
    private Product rentedProduct;

    @ManyToOne
    private User rentingUser;

    private DateTime rentalStarted;
    private DateTime rentalFinished;

    private boolean confirmed;

}
