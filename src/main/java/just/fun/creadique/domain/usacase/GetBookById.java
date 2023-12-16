package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.BookDao;
import just.fun.creadique.domain.entity.Book;

import java.util.Optional;

public class GetBookById {
    private final BookDao bookDao;

    public GetBookById(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Optional<Book> get(int id) {
        return bookDao.get(id);
    }
}
