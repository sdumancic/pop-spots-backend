package events.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import eventfees.api.rest.dto.EventFeeDto;
import eventtypes.api.rest.dto.EventTypeDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import user.api.rest.dto.UserDto;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class EventDto {
    private Integer id;
    private String name;
    private String description;
    private EventTypeDto eventType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime finishDateTime;
    private short maxParticipants;
    private EventFeeDto entryFee;
    private UserDto owner;
    private boolean isClosedEvent;
    private short status;
    private String location;

    @Override
    public String toString() {
        return "EventDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", startDateTime=" + startDateTime +
                ", finishDateTime=" + finishDateTime +
                ", maxParticipants=" + maxParticipants +
                ", entryFee=" + entryFee +
                ", owner=" + owner +
                ", isClosedEvent=" + isClosedEvent +
                ", status=" + status +
                ", location='" + location + '\'' +
                '}';
    }
}
