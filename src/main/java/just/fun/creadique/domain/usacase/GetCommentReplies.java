package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.CommentDao;
import just.fun.creadique.domain.entity.Comment;

import java.util.List;

public class GetCommentReplies {
    private final CommentDao commentDao;

    public GetCommentReplies(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> get(Comment repliedTo) {
        return commentDao.getByRepliedTo(repliedTo);
    }
}
