package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.models.User;
import mk.finki.ukim.mk.lab.models.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String firstName, String lastName, Role role);
}
