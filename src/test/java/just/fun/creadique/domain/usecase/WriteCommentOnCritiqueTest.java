package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.exceptions.NoSuchCritiqueException;
import just.fun.creadique.domain.usacase.WriteCommentOnCritique;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WriteCommentOnCritiqueTest extends BaseUseCaseTest {
    private WriteCommentOnCritique writeCommentOnCritique;

    @BeforeEach
    public void init() {
        writeCommentOnCritique = new WriteCommentOnCritique(commentDao, critiqueDao);
    }

    @Test
    public void testWriteCommentOnCritique() {
        Critique critique = Critique.builder()
                .id(1).title("TITLE").build();
        Comment comment = Comment.builder()
                .id(1)
                .content("didn't like it")
                .critique(critique)
                .build();
        assertThrows(NoSuchCritiqueException.class, () -> writeCommentOnCritique.write(comment));
        critiqueDao.create(critique);
        writeCommentOnCritique.write(comment);
        assertTrue(commentDao.get(1).isPresent());
        Comment written = commentDao.get(1).get();
        assertEquals(written.getId(), 1);
        assertEquals(written.getContent(), "didn't like it");
        assertEquals(written.getCritique().getId(), critique.getId());
    }
}
