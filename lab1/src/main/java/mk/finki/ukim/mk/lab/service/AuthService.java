package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.models.User;

public interface AuthService {
    User login(String username, String password);
}
