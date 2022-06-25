package pl.l.mateuszZieba.LibraryApp.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Author {
    private int Id;
    private String Name;
}
