package eventfees.domain.model;

import eventfeeprices.domain.model.EventFeePrices;
import events.domain.model.Event;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "[EventFees]", schema = "[Core]")
public class EventFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "active")
    private short active;

    @OneToMany(mappedBy = "eventFee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventFeePrices> eventsFeePrices = new ArrayList<>();

    public void addEventFeePrice(EventFeePrices eventFeePrice) {
        eventsFeePrices.add(eventFeePrice);
        eventFeePrice.setEventFee(this);
    }

    public void removeEvent(EventFeePrices eventFeePrice) {
        eventsFeePrices.remove(eventFeePrice);
        eventFeePrice.setEventFee(null);
    }

    @OneToMany(mappedBy = "eventFee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
        event.setEventFee(this);
    }

    public void removeEvent(Event event) {
        events.remove(event);
        event.setEventFee(null);
    }

}
