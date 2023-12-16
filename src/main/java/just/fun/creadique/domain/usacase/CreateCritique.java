package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.BookDao;
import just.fun.creadique.domain.dao.CritiqueDao;
import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.entity.Critique;

public class CreateCritique {
    private final CritiqueDao critiqueDao;
    private final BookDao bookDao;

    public CreateCritique(CritiqueDao critiqueDao, BookDao bookDao) {
        this.critiqueDao = critiqueDao;
        this.bookDao = bookDao;
    }

    public void create(Critique critiqueToCreate) {
        Book book = critiqueToCreate.getBook();
        if (!bookDao.isPresent(book.getId())) {
            bookDao.create(book);
        }
        critiqueDao.create(critiqueToCreate);
    }
}
