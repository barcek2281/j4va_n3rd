package kz.astanait.edu.j4va_n3rd.repository;

import kz.astanait.edu.j4va_n3rd.domain.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
