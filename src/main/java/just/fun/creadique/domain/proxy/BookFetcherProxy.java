package just.fun.creadique.domain.proxy;

import just.fun.creadique.domain.entity.Book;

import java.util.Optional;

public interface BookFetcherProxy {
    Optional<Book> fetchByTitle(String title);
    Optional<Book> fetchByAuthor(String author);
}
