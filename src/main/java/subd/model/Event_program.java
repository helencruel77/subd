package subd.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Event_program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    private Program program;
    @ManyToOne
    private Type_of_lesson type_of_lesson;
    @ManyToOne
    private Session session;
    @OneToMany
    private List<Expert> experts;
}
