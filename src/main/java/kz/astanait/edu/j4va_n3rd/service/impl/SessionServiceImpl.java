package kz.astanait.edu.j4va_n3rd.service.impl;

import kz.astanait.edu.j4va_n3rd.domain.session.Session;
import kz.astanait.edu.j4va_n3rd.domain.user.User;
import kz.astanait.edu.j4va_n3rd.repository.SessionRepository;
import kz.astanait.edu.j4va_n3rd.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    public Session create(User user) {
        Session session = new Session();
        session.setUser(user);
        session.setCreatedAt(LocalDateTime.now());
        session.setExpiresAt(LocalDateTime.now().plusHours(10));

        return sessionRepository.save(session);
    }

    @Override
    public Optional<Session> find(Long id) {
        return sessionRepository.findById(id);
    }
}
