package just.fun.creadique.domain.dao;

import just.fun.creadique.domain.entity.Comment;
import just.fun.creadique.domain.entity.Critique;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CommentDaoForTest implements CommentDao {

    private final Map<Integer, Comment> db;

    public CommentDaoForTest() {
        this.db = new HashMap<>();
    }

    @Override
    public List<Comment> findAll() {
        return db.values().stream().toList();
    }

    @Override
    public Optional<Comment> get(int id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public void create(Comment comment) {
        db.put(comment.getId(), comment);
    }

    @Override
    public void delete(int id) {
        db.remove(id);
    }

    @Override
    public boolean isPresent(int id) {
        return db.containsKey(id);
    }

    @Override
    public void update(int id, Comment comment) {
        db.put(id, comment);
    }

    @Override
    public List<Comment> getByCritique(Critique critique) {
        return db.values().stream()
                .filter(comment -> critique.equals(comment.getCritique()))
                .toList();
    }

    @Override
    public List<Comment> getByRepliedTo(Comment repliedTo) {
        return db.values().stream()
                .filter(comment -> repliedTo.equals(comment.getRepliedTo()))
                .toList();
    }
}
