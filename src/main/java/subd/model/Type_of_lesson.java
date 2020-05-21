package subd.model;
import javax.persistence.*;
@Entity
public class Type_of_lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
}
