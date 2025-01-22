package erik.vm.bike.trainer.rental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @NotNull
    @NotBlank(message = "Cant leave username blank!")
    @Column(unique = true)
    @Size(min = 6, max = 20, message = "Username has to be between 6-20 characters.")
    private String username;

    @NotNull
    @NotBlank(message = "Cant leave password blank!")
    @Size(min = 6, max = 20, message = "Password has to be between 6-20 characters.")
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany
    List<Rental> rentals = new ArrayList<>();


}
