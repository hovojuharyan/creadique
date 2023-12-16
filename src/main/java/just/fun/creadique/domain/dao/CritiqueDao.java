package just.fun.creadique.domain.dao;

import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.entity.Critique;

import java.util.List;
import java.util.Optional;

public interface CritiqueDao {
    List<Critique> findAll();
    Optional<Critique> get(int id);
    void create(Critique critique);
    void delete(int id);
    boolean isPresent(int id);
    void update(Critique critique);

    List<Critique> getByBook(Book book);
}
