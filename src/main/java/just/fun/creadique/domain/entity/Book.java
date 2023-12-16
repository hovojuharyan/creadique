package just.fun.creadique.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// isbndb.com
// https://openlibrary.org/dev/docs/api/search
// https://openlibrary.org/developers/dumps
@Data
@AllArgsConstructor
@Builder
public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final String coverUrl;
    private final int pages;
}
