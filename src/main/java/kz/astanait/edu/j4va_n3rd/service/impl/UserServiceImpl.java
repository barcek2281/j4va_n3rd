package kz.astanait.edu.j4va_n3rd.service.impl;

import kz.astanait.edu.j4va_n3rd.domain.user.User;
import kz.astanait.edu.j4va_n3rd.repository.UserRepository;
import kz.astanait.edu.j4va_n3rd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
