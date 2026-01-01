package kz.astanait.edu.j4va_n3rd.web.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.astanait.edu.j4va_n3rd.domain.session.Session;
import kz.astanait.edu.j4va_n3rd.props.SessionProps;
import kz.astanait.edu.j4va_n3rd.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SessionInterceptor implements HandlerInterceptor {
    private final SessionService sessionService;
    private final SessionProps sessionProps;

    @Override
    public boolean preHandle(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Object handler) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (sessionProps.getName().equals(c.getName())) {
                    try {
                        Long sessionId = Long.parseLong(c.getValue());
                        Session session = sessionService.find(sessionId)
                                .orElse(null);

                        if (session != null &&
                                session.getExpiresAt().isAfter(LocalDateTime.now())) {
                            request.setAttribute("currentUser", session.getUser());
                        }
                    } catch (NumberFormatException ignored) {

                    }
                }
            }
        }
        return true;

    }
}
