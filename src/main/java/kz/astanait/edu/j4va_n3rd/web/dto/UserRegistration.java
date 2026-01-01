package kz.astanait.edu.j4va_n3rd.web.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserRegistration {
    private String username;
    @Email
    private String email;
    private String password;
    private String confirmPassword;
}
