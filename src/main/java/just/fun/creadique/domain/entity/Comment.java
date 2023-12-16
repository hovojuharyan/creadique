package just.fun.creadique.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Comment {
    private int id;
    private final User user;
    private String content;
    private LocalDate createdAt;
    private final Critique critique;
    private final Comment repliedTo;
}
