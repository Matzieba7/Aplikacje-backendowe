package pl.l.mateuszZieba.LibraryApp.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private int Id;
    private String name;
    private Integer authorID;
    private LocalDateTime dateOfIssue;

}
