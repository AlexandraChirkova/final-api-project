package models;

import lombok.Data;
import java.util.List;

@Data
public class BooksListResponse {

    private List<BookDto> books;
}
