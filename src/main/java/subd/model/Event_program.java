package subd.model;
import javax.persistence.*;
@Entity
public class Event_program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    //programId
    //type ofleson id
    //session id
}
