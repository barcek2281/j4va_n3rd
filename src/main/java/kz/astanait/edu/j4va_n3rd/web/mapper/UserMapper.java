package kz.astanait.edu.j4va_n3rd.web.mapper;

import kz.astanait.edu.j4va_n3rd.domain.user.User;
import kz.astanait.edu.j4va_n3rd.web.dto.UserRegistration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegistration userRegistration);
}
