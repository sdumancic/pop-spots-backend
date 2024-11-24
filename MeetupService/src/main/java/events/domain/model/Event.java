package events.domain.model;

//import com.microsoft.sqlserver.jdbc.Geometry;

import eventfees.domain.model.EventFee;
import eventtypes.domain.model.EventType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.Geometry;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "[Events]", schema = "[Core]")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "start_ts")
    private LocalDateTime startDateTime;

    @Column(name = "end_ts")
    private LocalDateTime finishDateTime;

    @Column(name = "max_no_participants")
    private short maxParticipants;

    @Column(name = "is_closed_event")
    private short isClosedEvent;

    @Column(name = "status_id")
    private short status;

    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "location", columnDefinition = "geometry")
    @JdbcTypeCode(SqlTypes.GEOMETRY)
    private Geometry location;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private EventType eventType;

    @ManyToOne
    @JoinColumn(name = "entry_fee_id", nullable = true)
    private EventFee eventFee;
}
