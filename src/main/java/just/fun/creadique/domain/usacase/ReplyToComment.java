package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.CommentDao;
import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.exceptions.NoSuchCommentException;

public class ReplyToComment {
    private final CommentDao commentDao;

    public ReplyToComment(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public void reply(Comment theReply) {
        int repliedToId = theReply.getRepliedTo().getId();
        if (!commentDao.isPresent(repliedToId)) throw new NoSuchCommentException(repliedToId);
        commentDao.create(theReply);
    }
}
