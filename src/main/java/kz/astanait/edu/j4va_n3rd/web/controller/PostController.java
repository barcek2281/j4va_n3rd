package kz.astanait.edu.j4va_n3rd.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import kz.astanait.edu.j4va_n3rd.domain.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PostController {

    @GetMapping("/")

    public String index(HttpServletRequest request, Model model) {
        User user = (User) request.getAttribute("currentUser");
        model.addAttribute("user", user);
        return "index";
    }
}
