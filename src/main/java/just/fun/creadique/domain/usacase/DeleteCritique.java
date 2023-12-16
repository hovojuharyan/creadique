package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.CritiqueDao;
import just.fun.creadique.domain.exceptions.NoSuchCritiqueException;

public class DeleteCritique {
    private final CritiqueDao critiqueDao;

    public DeleteCritique(CritiqueDao critiqueDao) {
        this.critiqueDao = critiqueDao;
    }

    public void delete(int id) {
        if (!critiqueDao.isPresent(id)) throw new NoSuchCritiqueException(id);
        critiqueDao.delete(id);
    }
}
