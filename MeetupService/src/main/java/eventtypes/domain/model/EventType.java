package eventtypes.domain.model;

import events.domain.model.Event;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "[EventTypes]", schema = "[Core]")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "active")
    private short active;

    @OneToMany(mappedBy = "eventType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
        event.setEventType(this);
    }

    public void removeEvent(Event event) {
        events.remove(event);
        event.setEventType(null);
    }
}
