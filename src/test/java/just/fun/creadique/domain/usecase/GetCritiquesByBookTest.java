package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.entity.Critique;
import just.fun.creadique.domain.usacase.GetCritiquesByBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetCritiquesByBookTest extends BaseUseCaseTest {
    private GetCritiquesByBook getCritiquesByBook;

    @BeforeEach
    public void init() {
        getCritiquesByBook = new GetCritiquesByBook(critiqueDao);
    }

    @Test
    public void testGetCritiquesByBook() {
        Book book1 = Book.builder()
                .id(1)
                .title("BOOK 1")
                .build();
        Book book2 = Book.builder()
                .id(2)
                .title("BOOK 2")
                .build();
        Critique critique1onBook1 = Critique.builder()
                .id(1).title("1 - CRITIQUING BOOK 1")
                .book(book1)
                .build();
        Critique critique2onBook1 = Critique.builder()
                .id(2).title("2 - CRITIQUING BOOK 1")
                .book(book1)
                .build();
        Critique critique1onBook2 = Critique.builder()
                .id(3).title("1 - CRITIQUING BOOK 2")
                .book(book2)
                .build();
        bookDao.create(book1);
        bookDao.create(book2);
        critiqueDao.create(critique1onBook1);
        critiqueDao.create(critique2onBook1);
        critiqueDao.create(critique1onBook2);
        List<Critique> onBook1 = getCritiquesByBook.get(book1);
        List<Critique> onBook2 = getCritiquesByBook.get(book2);
        assertEquals(onBook1.size(), 2);
        assertEquals(onBook2.size(), 1);
        assertEquals(onBook1.getFirst().getId(), 1);
        assertEquals(onBook2.getFirst().getId(), 3);
    }
}
