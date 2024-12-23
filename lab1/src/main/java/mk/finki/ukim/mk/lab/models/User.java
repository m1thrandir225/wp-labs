package mk.finki.ukim.mk.lab.models;

import jakarta.persistence.*;
import mk.finki.ukim.mk.lab.models.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "music_users")
public class User implements UserDetails {
    @Id
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    private Role role;

    @Column(name="is_account_non_expired")
    private boolean isAccountNonExpired = true;

    @Column(name="is_account_non_locked")
    private boolean isAccountNonLocked = true;

    @Column(name="is_credentials_non_expired")
    private boolean isCredentialsNonExpired = true;

    @Column(name="is_enabled")
    private boolean isEnabled = true;

    public User() {}

    public User(String username, String password, String firstName, String lastName, Role role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
