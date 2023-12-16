package just.fun.creadique.domain.exceptions;

public class NoSuchCritiqueException extends RuntimeException {
    public NoSuchCritiqueException(int id) {
        super("No Critique with id: " + id + " is present!");
    }
}
