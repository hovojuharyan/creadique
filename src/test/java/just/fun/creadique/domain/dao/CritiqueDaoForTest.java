package just.fun.creadique.domain.dao;

import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.entity.Critique;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CritiqueDaoForTest implements CritiqueDao {

    private final Map<Integer, Critique> db;

    public CritiqueDaoForTest() {
        this.db = new HashMap<>();
    }

    @Override
    public List<Critique> findAll() {
        return db.values().stream().toList();
    }

    @Override
    public Optional<Critique> get(int id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public void create(Critique critique) {
        db.put(critique.getId(), critique);
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
    public void update(Critique critique) {
        db.put(critique.getId(), critique);
    }

    @Override
    public List<Critique> getByBook(Book book) {
        return db.values().stream()
                .filter(critique -> critique.getBook().equals(book))
                .toList();
    }
}
