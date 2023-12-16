package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.entity.User;
import just.fun.creadique.domain.exceptions.NoSuchCritiqueException;
import just.fun.creadique.domain.usacase.UpdateCritique;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateCritiqueTest extends BaseUseCaseTest {

    private UpdateCritique updateCritique;

    @BeforeEach
    public void init() {
        updateCritique = new UpdateCritique(critiqueDao);
    }

    @Test
    public void testUpdate() {
        Critique critique = Critique.builder()
                .id(1)
                .title("TITLE")
                .content("CONTENT")
                .book(Book.builder().build())
                .user(User.builder().build())
                .build();
        Critique change = Critique.builder()
                .id(1)
                .title("NEW TITLE")
                .content("NEW CONTENT")
                .build();
        assertThrows(NoSuchCritiqueException.class, () -> updateCritique.update(change));
        critiqueDao.create(critique);
        updateCritique.update(change);
        assertTrue(critiqueDao.get(1).isPresent());
        Critique updated = critiqueDao.get(1).get();
        assertEquals(updated.getId(), 1);
        assertEquals(updated.getTitle(), "NEW TITLE");
        assertEquals(updated.getContent(), "NEW CONTENT");
    }

}
