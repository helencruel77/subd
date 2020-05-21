package subd.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Type_of_lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany
    private List<Event_program> event_programs;
}
