package subd.model;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Time time;
    @OneToMany
    private List<Event_program> event_programs;
}

