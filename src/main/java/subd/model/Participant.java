package subd.model;
import javax.persistence.*;
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fio;

    private String email;
    @ManyToOne
    private Session session;

    public void Constructor(Integer id, String fio, String email){
        this.fio = fio;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id  +"," + "\n" +
                "name = " + fio + "\n" +
                "email = " + email +
                '}';
    }
}
