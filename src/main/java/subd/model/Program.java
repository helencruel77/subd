package subd.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String time;
    @OneToMany
    private List<EventProgram> eventPrograms;

    public void Constructor(Integer id, String name, String time){
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id  +"," + "\n" +
                "name = " + name +
                "time = " + time +
                '}';
    }
}

