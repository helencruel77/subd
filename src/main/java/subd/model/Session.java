package subd.model;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String place;
    private Date dataFrom;
    private Date dataTo;
    @OneToMany
    private List<Participant> participants;
    @OneToMany
    private List<EventProgram> eventPrograms;

    public void Constructor(Integer id, String name, String place, Date dataFrom, Date dataTo){
        this.name = name;
        this.place = place;
        this.dataFrom = dataFrom;
        this.dataTo = dataTo;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id  +"," + "\n" +
                "name = " + name + "\n" +
                "place = " + place + "\n" +
                "dataFrom = " + dataFrom + "\n" +
                "dataTo = " + dataTo +
                '}';
    }
}
