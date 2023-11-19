package Model;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Administrator extends User{
     private Set<String> droits;
}
