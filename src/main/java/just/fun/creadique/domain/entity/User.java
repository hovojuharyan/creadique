package just.fun.creadique.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class User {
    private final String username;
    private String email;
    private String password;
    private LocalDate birthdate;
    private String image;
}
