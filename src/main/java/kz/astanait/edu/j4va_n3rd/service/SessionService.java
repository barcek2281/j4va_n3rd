package kz.astanait.edu.j4va_n3rd.service;

import kz.astanait.edu.j4va_n3rd.domain.session.Session;
import kz.astanait.edu.j4va_n3rd.domain.user.User;

import java.util.Optional;

public interface SessionService {
    Session create(User user);
    Optional<Session> find(Long id);
}
