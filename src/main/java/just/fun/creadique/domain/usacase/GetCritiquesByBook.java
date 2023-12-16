package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.CritiqueDao;
import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.entity.Critique;

import java.util.List;

public class GetCritiquesByBook {
    private final CritiqueDao critiqueDao;

    public GetCritiquesByBook(CritiqueDao critiqueDao) {
        this.critiqueDao = critiqueDao;
    }

    public List<Critique> get(Book book) {
        return critiqueDao.getByBook(book);
    }
}
