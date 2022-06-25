package pl.l.mateuszZieba.LibraryApp.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int Id;
    private String name;
    private String surname;
    private LocalDateTime dateOfBirth;
    private String email;
    private int typeID;

}
