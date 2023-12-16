package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.CommentDao;
import just.fun.creadique.domain.dao.CritiqueDao;
import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.exceptions.NoSuchCritiqueException;

public class WriteCommentOnCritique {
    private final CommentDao commentDao;
    private final CritiqueDao critiqueDao;

    public WriteCommentOnCritique(CommentDao commentDao, CritiqueDao critiqueDao) {
        this.commentDao = commentDao;
        this.critiqueDao = critiqueDao;
    }

    public void write(Comment comment) {
        int critiqueId = comment.getCritique().getId();
        if (!critiqueDao.isPresent(critiqueId)) throw new NoSuchCritiqueException(critiqueId);
        commentDao.create(comment);
    }
}
