package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.CommentDao;
import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.entity.Critique;

import java.util.List;

public class GetCommentsByCritique {
    private final CommentDao commentDao;

    public GetCommentsByCritique(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> get(Critique critique) {
        return commentDao.getByCritique(critique);
    }

}
