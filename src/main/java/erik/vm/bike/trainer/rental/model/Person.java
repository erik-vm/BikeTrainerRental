package erik.vm.bike.trainer.rental.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "person_id")
    private UUID personId;

    @NotNull
    @Size(min = 1, max = 50, message = "Firstname has to be between 1-50 characters.")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50, message = "Lastname has to be between 1-50 characters.")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private User user;
}
