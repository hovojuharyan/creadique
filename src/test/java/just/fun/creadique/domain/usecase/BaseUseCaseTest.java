package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.dao.*;
import org.junit.jupiter.api.BeforeEach;

public class BaseUseCaseTest {
    protected CritiqueDao critiqueDao;
    protected CommentDao commentDao;
    protected UserDao userDao;
    protected BookDao bookDao;

    @BeforeEach
    public void setup() {
        critiqueDao = new CritiqueDaoForTest();
        commentDao = new CommentDaoForTest();
        userDao = new UserDaoForTest();
        bookDao = new BookDaoForTest();
    }
}
