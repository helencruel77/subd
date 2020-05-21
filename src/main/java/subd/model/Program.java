package subd.model;
import javax.persistence.*;
import java.sql.Time;
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Time time;
}

