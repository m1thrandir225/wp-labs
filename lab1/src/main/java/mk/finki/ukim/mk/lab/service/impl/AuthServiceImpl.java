package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.models.User;
import mk.finki.ukim.mk.lab.models.exceptions.InvalidArgumentsException;
import mk.finki.ukim.mk.lab.models.exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import mk.finki.ukim.mk.lab.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new  InvalidArgumentsException();
        }
        return this.userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }
}