package subd.model;
import javax.persistence.*;
@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fio;
    private String email;
    //session id
}
