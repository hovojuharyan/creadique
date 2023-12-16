package just.fun.creadique.domain.proxy;

import just.fun.creadique.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public class BookFetcherProxyForTest implements BookFetcherProxy {

    private final List<Book> bookDB;

    public BookFetcherProxyForTest() {
        this.bookDB = List.of(
                Book.builder()
                        .id(1)
                        .title("The Little Prince")
                        .author("Antoine de Saint-Exupéry")
                        .pages(96)
                        .build(),
                Book.builder()
                        .id(2)
                        .title("Lord of the Flies")
                        .author("William Golding")
                        .pages(182)
                        .build(),
                Book.builder()
                        .id(3)
                        .title("The Alchemist")
                        .author("Paulo Coelho")
                        .pages(182)
                        .build(),
                Book.builder()
                        .id(4)
                        .title("The Catcher in the Rye")
                        .author("J.D. Salinger")
                        .pages(234)
                        .build(),
                Book.builder()
                        .id(5)
                        .title("Meditations")
                        .author("Marcus Aurelius")
                        .pages(254)
                        .build(),
                Book.builder()
                        .id(6)
                        .title("The Art of War")
                        .author("Sun Tzu")
                        .pages(273)
                        .build(),
                Book.builder()
                        .id(7)
                        .title("Four Thousand Weeks: Time Management for Mortals")
                        .author("Oliver Burkeman")
                        .pages(273)
                        .build(),
                Book.builder()
                        .id(8)
                        .title("The Adventures of Huckleberry Finn")
                        .author("Mark Twain")
                        .pages(327)
                        .build(),
                Book.builder()
                        .id(9)
                        .title("To Kill a Mockingbird")
                        .author("Harper Lee")
                        .pages(323)
                        .build(),
                Book.builder()
                        .id(10)
                        .title("1984")
                        .author("George Orwell")
                        .pages(298)
                        .build()
        );
    }

    @Override
    public Optional<Book> fetchByTitle(String title) {
        return bookDB.stream()
                .filter(book -> title.equals(book.getTitle()))
                .findFirst();
    }

    @Override
    public Optional<Book> fetchByAuthor(String author) {
        return bookDB.stream()
                .filter(book -> author.equals(book.getAuthor()))
                .findFirst();
    }
}
