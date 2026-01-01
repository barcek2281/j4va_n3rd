package kz.astanait.edu.j4va_n3rd.repository;


import kz.astanait.edu.j4va_n3rd.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
