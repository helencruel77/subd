package subd.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String place;
    private Timestamp dataFrom;
    private Timestamp dataTo;
    @OneToMany
    private List<Participant> participants;
    @OneToMany
    private List<Event_program> event_programs;
}
