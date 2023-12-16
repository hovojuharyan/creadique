package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.CritiqueDao;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.exceptions.NoSuchCritiqueException;

public class UpdateCritique {
    private final CritiqueDao critiqueDao;

    public UpdateCritique(CritiqueDao critiqueDao) {
        this.critiqueDao = critiqueDao;
    }

    public void update(Critique change) {
        if (!critiqueDao.isPresent(change.getId())) throw new NoSuchCritiqueException(change.getId());
        critiqueDao.update(change);
    }
}
