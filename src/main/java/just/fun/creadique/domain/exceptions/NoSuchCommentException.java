package just.fun.creadique.domain.exceptions;

public class NoSuchCommentException extends RuntimeException {
    public NoSuchCommentException(int id) {
        super("No Comment with id: " + id + " is present!");
    }
}
