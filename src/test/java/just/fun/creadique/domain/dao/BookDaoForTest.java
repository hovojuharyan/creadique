package just.fun.creadique.domain.dao;

import just.fun.creadique.domain.entity.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BookDaoForTest implements BookDao{

    private final Map<Integer, Book> db;

    public BookDaoForTest() {
        this.db = new HashMap<>();
    }

    @Override
    public List<Book> findAll() {
        return db.values().stream().toList();
    }

    @Override
    public Optional<Book> get(int id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public void create(Book book) {
        db.put(book.getId(), book);
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
    public void update(Book book) {
        db.put(book.getId(), book);
    }
}
