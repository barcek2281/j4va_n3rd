package kz.astanait.edu.j4va_n3rd.domain.post;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Post {
    private String title;
    private String description;
    private Timestamp created;
}
