package subd.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Type_of_lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany
    private List<Event_program> event_programs;

    public void Constructor(Integer id, String name, String place, Timestamp dataFrom, Timestamp dataTo){
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id  +"," + "\n" +
                "name = " + name +
                '}';
    }
}
