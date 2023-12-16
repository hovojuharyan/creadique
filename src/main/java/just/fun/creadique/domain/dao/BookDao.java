package just.fun.creadique.domain.dao;

import just.fun.creadique.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    List<Book> findAll();
    Optional<Book> get(int id);
    void create(Book book);
    void delete(int id);
    boolean isPresent(int id);
    void update(Book book);
}
