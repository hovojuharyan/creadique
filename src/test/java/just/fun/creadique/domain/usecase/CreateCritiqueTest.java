package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.entity.User;
import just.fun.creadique.domain.usacase.CreateCritique;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateCritiqueTest extends BaseUseCaseTest {

    private CreateCritique createCritique;

    @BeforeEach
    public void init() {
        createCritique = new CreateCritique(critiqueDao, bookDao);
    }

    @Test
    public void testCreate() {
        Critique critiqueToCreate = Critique.builder()
                .id(1)
                .title("TITLE")
                .book(Book.builder().title("1234567890").build())
                .user(User.builder().username("a_username").build())
                .build();
        createCritique.create(critiqueToCreate);
        assertTrue(critiqueDao.get(1).isPresent());
        Critique created = critiqueDao.get(1).get();
        assertEquals(created.getTitle(), "TITLE");
        assertEquals(created.getBook().getTitle(), "1234567890");
        assertEquals(created.getUser().getUsername(), "a_username");
    }

}
