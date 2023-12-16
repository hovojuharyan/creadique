package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.usacase.GetCommentReplies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCommentRepliesTest extends BaseUseCaseTest {
    private GetCommentReplies getCommentReplies;

    @BeforeEach
    public void init() {
        getCommentReplies = new GetCommentReplies(commentDao);
    }

    @Test
    public void testGetCommentReplies() {
        Critique critique = Critique.builder().id(1).build();
        Comment comment = Comment.builder()
                .id(1).critique(critique).content("so")
                .build();
        Comment reply1 = Comment.builder()
                .id(2)
                .critique(critique)
                .content("what?")
                .repliedTo(comment)
                .build();
        Comment reply2 = Comment.builder()
                .id(3)
                .critique(critique)
                .content("WHAT!?")
                .repliedTo(comment)
                .build();
        critiqueDao.create(critique);
        commentDao.create(comment);
        commentDao.create(reply1);
        commentDao.create(reply2);
        List<Comment> replies = getCommentReplies.get(comment);
        assertEquals(replies.size(), 2);
        assertEquals(replies.getFirst().getId(), 2);
        assertEquals(replies.getFirst().getContent(), "what?");
        assertEquals(replies.getLast().getId(), 3);
        assertEquals(replies.getLast().getContent(), "WHAT!?");
    }
}
