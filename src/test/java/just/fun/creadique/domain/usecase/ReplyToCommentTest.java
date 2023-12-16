package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.exceptions.NoSuchCommentException;
import just.fun.creadique.domain.usacase.ReplyToComment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplyToCommentTest extends BaseUseCaseTest {
    private ReplyToComment replyToComment;

    @BeforeEach
    public void init() {
        replyToComment = new ReplyToComment(commentDao);
    }

    @Test
    public void testReplyToComment() {
        Critique critique = Critique.builder().id(1).build();
        Comment comment = Comment.builder().id(1).critique(critique).build();
        Comment theReply = Comment.builder()
                .id(2)
                .content("the reply")
                .repliedTo(comment)
                .critique(critique)
                .build();
        assertThrows(NoSuchCommentException.class, () -> replyToComment.reply(theReply));
        critiqueDao.create(critique);
        commentDao.create(comment);
        replyToComment.reply(theReply);
        assertTrue(commentDao.get(2).isPresent());
        Comment replied = commentDao.get(2).get();
        assertEquals(replied.getId(), 2);
        assertEquals(replied.getContent(), "the reply");
        assertEquals(replied.getRepliedTo().getId(), 1);
        assertEquals(replied.getCritique().getId(), critique.getId());
    }
}
