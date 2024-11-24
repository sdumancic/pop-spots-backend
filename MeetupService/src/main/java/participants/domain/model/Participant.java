package participants.domain.model;

//import com.microsoft.sqlserver.jdbc.Geometry;

import events.domain.model.Event;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import user.domain.model.Users;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "[InvitedParticipants]", schema = "[Core]")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sent_ts")
    private LocalDateTime sendTs;

    @Column(name = "response_id")
    private short responseId;

    @Column(name = "response_ts")
    private LocalDateTime responseTs;

    @Column(name = "response_message", length = 50)
    private String responseMessage;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "invited_by_user_id", nullable = false)
    private Users invitedByUser;

}
