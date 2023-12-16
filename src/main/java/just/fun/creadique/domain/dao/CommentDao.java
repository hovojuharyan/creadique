package just.fun.creadique.domain.dao;

import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.entity.Critique;

import java.util.List;
import java.util.Optional;

public interface CommentDao {
    List<Comment> findAll();
    Optional<Comment> get(int id);
    void create(Comment comment);
    void delete(int id);
    boolean isPresent(int id);
    void update(int id, Comment comment);

    List<Comment> getByCritique(Critique critique);

    List<Comment> getByRepliedTo(Comment repliedTo);
}
