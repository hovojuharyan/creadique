package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.usacase.DeleteCritique;
import just.fun.creadique.domain.exceptions.NoSuchCritiqueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteCritiqueTest extends BaseUseCaseTest {
    private DeleteCritique deleteCritique;

    @BeforeEach
    public void init() {
        deleteCritique = new DeleteCritique(critiqueDao);
    }

    @Test
    public void testDelete() {
        Critique critique = Critique.builder()
                .id(1)
                .build();
        assertThrows(NoSuchCritiqueException.class, () -> deleteCritique.delete(1));
        critiqueDao.create(critique);
        assertTrue(critiqueDao.isPresent(1));
        deleteCritique.delete(1);
        assertFalse(critiqueDao.isPresent(1));
    }

}
