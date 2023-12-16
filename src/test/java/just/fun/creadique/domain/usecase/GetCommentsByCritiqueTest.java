package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.usacase.GetCommentsByCritique;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCommentsByCritiqueTest extends BaseUseCaseTest {
    private GetCommentsByCritique getCommentsByCritique;

    @BeforeEach
    public void init() {
        getCommentsByCritique = new GetCommentsByCritique(commentDao);
    }

    @Test
    public void testGetCommentsByCritique() {
        Critique critique = Critique.builder()
                .id(1)
                .build();
        Comment comment1 = Comment.builder()
                .id(1).critique(critique).content("nah")
                .build();
        Comment comment2 = Comment.builder()
                .id(2).critique(critique).content("yep")
                .build();
        critiqueDao.create(critique);
        commentDao.create(comment1);
        commentDao.create(comment2);
        List<Comment> byCritique = getCommentsByCritique.get(critique);
        assertEquals(byCritique.size(), 2);
        assertEquals(byCritique.getFirst().getId(), 1);
        assertEquals(byCritique.getLast().getId(), 2);
    }
}
