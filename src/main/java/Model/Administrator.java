package Model;
import java.util.Set;

public class Administrator extends User {
     private Set<String> droits;

     public Administrator() {
     }
     public Administrator(int id, String name, String email, Set<String> droits) {
          super(id, name, email);
          this.droits = droits;
     }
     public Set<String> getDroits() {
          return droits;
     }
     public void setDroits(Set<String> droits) {
          this.droits = droits;
     }
}

