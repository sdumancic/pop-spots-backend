package events.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import eventfees.api.rest.dto.EventFeeDto;
import eventtypes.api.rest.dto.EventTypeDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateEventDto {
    @NotEmpty
    @Size(min = 5, max = 30)
    private String name;
    @Size(max = 200)
    private String description;
    @NotEmpty
    private EventTypeDto eventType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime finishDateTime;
    @Max(32767)
    private short maxParticipants;
    private EventFeeDto entryFee;
    private boolean isClosedEvent;
    private short status;
    private String location;

    @Override
    public String toString() {
        return "EventDto{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", startDateTime=" + startDateTime +
                ", finishDateTime=" + finishDateTime +
                ", maxParticipants=" + maxParticipants +
                ", entryFee=" + entryFee +
                ", isClosedEvent=" + isClosedEvent +
                ", status=" + status +
                ", location='" + location + '\'' +
                '}';
    }
}
