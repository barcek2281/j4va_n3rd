package kz.astanait.edu.j4va_n3rd.web.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import kz.astanait.edu.j4va_n3rd.domain.session.Session;
import kz.astanait.edu.j4va_n3rd.domain.user.User;
import kz.astanait.edu.j4va_n3rd.props.SessionProps;
import kz.astanait.edu.j4va_n3rd.service.SessionService;
import kz.astanait.edu.j4va_n3rd.service.UserService;
import kz.astanait.edu.j4va_n3rd.web.dto.UserLogin;
import kz.astanait.edu.j4va_n3rd.web.dto.UserRegistration;
import kz.astanait.edu.j4va_n3rd.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SessionService sessionService;
    private final UserMapper userMapper;

    private final SessionProps sessionProps;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("userLogin", new UserLogin());
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userRegistration", new UserRegistration());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserRegistration userRegistration,
                           BindingResult result,
                           HttpServletResponse response) {
        if (result.hasErrors()) {
            return "register";
        }

        if (!userRegistration.getPassword()
                .equals(userRegistration.getConfirmPassword())) {
            result.rejectValue("confirmPassword",
                    "password.mismatch",
                    "Passwords do not match");
            return "register";
        }
        User user = userMapper.toEntity(userRegistration);
        userService.create(user);

        Session session = sessionService.create(user);

        Cookie cookie = new Cookie(sessionProps.getName(), session.getId().toString());
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(sessionProps.getExpiration());
        response.addCookie(cookie);

        return "redirect:/";
    }
}
