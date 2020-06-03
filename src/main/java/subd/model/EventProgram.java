package subd.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class EventProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    private Program program;
    @ManyToOne
    private TypeOfLesson typeOfLesson;
    @ManyToOne
    private Session session;
    @OneToMany
    private List<Expert> experts;

    public void Constructor(Integer id, String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id  +"," + "\n" +
                "name = " + name +
                '}';
    }
}
