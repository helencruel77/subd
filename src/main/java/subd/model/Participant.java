package subd.model;
import javax.persistence.*;
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    @ManyToOne
    private Session session;

    public void Constructor(Integer id, String fio, String email){
        this.lastName = fio;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id  +"," + "\n" +
                "name = " + lastName + "\n" +
                "email = " + email +
                '}';
    }
}
