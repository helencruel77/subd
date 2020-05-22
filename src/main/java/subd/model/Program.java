package subd.model;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String time;
    @OneToMany
    private List<Event_program> event_programs;

    public void Constructor(Integer id, String name, String time){
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id  +"," + "\n" +
                "name = " + name +
                "time = " + time +
                '}';
    }
}

