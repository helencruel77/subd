package subd.model;
import javax.persistence.*;
import java.sql.Timestamp;
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String place;
    private Timestamp dataFrom;
    private Timestamp dataTo;
}
