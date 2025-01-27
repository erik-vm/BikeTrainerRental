package erik.vm.bike.trainer.rental.model;

import erik.vm.bike.trainer.rental.model.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

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

    @Enumerated(EnumType.STRING)
    UserRole role;

    @OneToMany(mappedBy = "rentingUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Rental> rentals = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
