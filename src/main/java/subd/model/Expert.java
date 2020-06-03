package subd.model;
import javax.persistence.*;
@Entity
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String lastName;
    @ManyToOne
    private EventProgram event_program;
    public void Constructor(Integer id, String fio){
        this.lastName = fio;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id  +"," + "\n" +
                "name = " + lastName +
                '}';
    }
}
