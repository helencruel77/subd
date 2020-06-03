package subd.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class TypeOfLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany
    private List<EventProgram> eventPrograms;

    public void Constructor(Integer id, String name, String place, Timestamp dataFrom, Timestamp dataTo){
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
