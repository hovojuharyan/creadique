package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.entity.User;
import just.fun.creadique.domain.usacase.GetCritiqueById;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetCritiqueByIdTest extends BaseUseCaseTest {
    private GetCritiqueById getCritiqueById;

    @BeforeEach
    public void init() {
        getCritiqueById = new GetCritiqueById(critiqueDao);
    }

    @Test
    public void testGetCritiqueById() {
        Critique critique = Critique.builder()
                .id(1)
                .title("TITLE")
                .book(Book.builder().build())
                .user(User.builder().build())
                .build();
        Optional<Critique> before = getCritiqueById.get(1);
        assertTrue(before.isEmpty());
        critiqueDao.create(critique);
        Optional<Critique> got = getCritiqueById.get(1);
        assertTrue(got.isPresent());
        assertEquals(got.get().getId(), 1);
        assertEquals(got.get().getTitle(), "TITLE");
    }
}
