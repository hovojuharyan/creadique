package just.fun.creadique.domain.usecase;

import just.fun.creadique.domain.entity.Book;
import just.fun.creadique.domain.proxy.BookFetcherProxy;
import just.fun.creadique.domain.proxy.BookFetcherProxyForTest;
import just.fun.creadique.domain.usacase.GetBookById;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetBookByIdTest extends BaseUseCaseTest {
    private GetBookById getBookById;
    private BookFetcherProxy bookFetcherProxy;

    @BeforeEach
    public void init() {
        getBookById = new GetBookById(bookDao);
        bookFetcherProxy = new BookFetcherProxyForTest();
    }

    @Test
    public void testGetBookById() {
        Book book = Book.builder()
                .id(1)
                .title("Crime And Punishment")
                .author("Fyodor Dostoevsky")
                .pages(608)
                .coverUrl("1234567890")
                .build();
        Optional<Book> before = getBookById.get(1);
        assertTrue(before.isEmpty());
        bookDao.create(book);
        Optional<Book> got = getBookById.get(1);
        assertTrue(got.isPresent());
        Book gotBook = got.get();
        assertEquals(book.getId(), gotBook.getId());
        assertEquals(book.getTitle(), gotBook.getTitle());
    }
}
