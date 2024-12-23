package mk.finki.ukim.mk.lab.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.models.User;
import mk.finki.ukim.mk.lab.models.enums.Role;
import mk.finki.ukim.mk.lab.service.AuthService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.DocFlavor;


public class AuthenticationController {
    private final UserService userService;
    private final AuthService authService;

    public AuthenticationController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/register")
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String repeatedPassword,
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        try {
            this.userService.register(username, password, repeatedPassword, firstName, lastName, Role.ROLE_USER);
            return "redirect:/login";
        } catch (RuntimeException ex){
            return "redirect:/register?error=" + ex.getMessage();
        }
    }
    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model) {
        model.addAttribute("bodyContent", "access-denied");
        return "master-template";
    }
    @GetMapping("/logout")
    public String logoutUser(HttpServletRequest request, Model model) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
