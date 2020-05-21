package subd.model;
import javax.persistence.*;
@Entity
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fio;
    //event id
}
