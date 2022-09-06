package com.lvt.waifuranker.controllers;


import ch.qos.logback.core.status.ErrorStatus;
import ch.qos.logback.core.status.InfoStatus;
import ch.qos.logback.core.status.Status;
import com.lvt.waifuranker.controllers.forms.RegistrationForm;
import com.lvt.waifuranker.models.User;
import com.lvt.waifuranker.services.UserService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class AuthenticationController {
    private final UserService userService;
    private static final String LOGGED_IN_TOKEN = "loggedIn";
    private static final String USERNAME_REGEX = "";


    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        if (isLoggedIn()) {
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginPage(Model model, User user) {

        if (isLoggedIn()) {
            return "redirect:/";
        }

        if (isLoginValid(user.getUsername(), user.getPassword())) {
            login(user.getUsername());
            return "redirect:/";
        } else {
            model.addAttribute("wrongInput", true);
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logoutPage() {
        logout();
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registrationPage() {
        if (isLoggedIn()) {
            return "redirect:/";
        }
        return "register";
    }

    @PostMapping("/register")
    public String registrationPage(Model model, RegistrationForm form) {

        System.out.println(form.getUsername() + form.getPassword());

        if (isLoggedIn()) {
            return "redirect:/";
        }

        User user = new User();
        form.apply(user);

        System.out.println(user.getUsername() + user.getPassword());

        int res = registerPerson(user);
        if (res == 1) {
            login(form.getUsername());
            return "redirect:/";
        } else {
            model.addAttribute("registrationFailed", true);
            model.addAttribute("errorMessage", "Username invalid or already taken");
            return "register";
        }


    }


    public int registerPerson(User user) {
        if (!isUsernameValid(user.getUsername())) {
            System.out.println("Username was invalid");
            return 0;
        }

        if (userService.getUserByUsername(user.getUsername()) != null) {
            System.out.println("User already exists");
            return 0;
        }

        System.out.println("reg: " + user.getUsername() + user.getPassword() + user.getWaifuList());

        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);

        userService.addUser(user);

        return 1;
    }

    public boolean isLoginValid(String username, String password) {
        if (!isUsernameValid(username)) {
            return false;
        }

        User user = userService.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        return true;

    }

    public static boolean isUsernameValid(String username) {
        return true;
    }

    public static boolean isLoggedIn() {
        return getCurrentUsersUsername() != null;
    }

    public static String hashPassword(String password) {
        return password;
    }

    public static String getCurrentUsersUsername() {
        return (String) session().getAttribute(LOGGED_IN_TOKEN);
    }

    public static void login(String username) {
        session().setAttribute(LOGGED_IN_TOKEN, username);
    }


    public static void logout() {
        session().removeAttribute(LOGGED_IN_TOKEN);
    }


    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true);
    }

    public User getCurrentUser() {
        return userService.getUserByUsername(getCurrentUsersUsername());
    }

}
