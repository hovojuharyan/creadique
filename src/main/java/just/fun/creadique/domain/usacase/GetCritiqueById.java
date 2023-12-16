package just.fun.creadique.domain.usacase;

import just.fun.creadique.domain.dao.CritiqueDao;
import just.fun.creadique.domain.entity.Critique;

import java.util.Optional;

public class GetCritiqueById {
    private final CritiqueDao critiqueDao;

    public GetCritiqueById(CritiqueDao critiqueDao) {
        this.critiqueDao = critiqueDao;
    }

    public Optional<Critique> get(int id) {
        return critiqueDao.get(id);
    }
}
