package just.fun.creadique.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Critique {
    private final int id;
    private final Book book;
    private String title;
    private String content;
    private final User user;
    private final LocalDate createdAt;
}
