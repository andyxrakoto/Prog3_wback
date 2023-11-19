package Model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private int Id;
    private String name;
    private String mail;
}
