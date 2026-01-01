package kz.astanait.edu.j4va_n3rd.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "spring.sessions")
public class SessionProps {
    private String name;
    private int expiration;
}
