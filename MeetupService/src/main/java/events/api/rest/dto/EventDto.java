package events.api.rest.dto;

import eventfees.api.rest.dto.EventFeeDto;
import events.domain.model.Event;
import eventtypes.api.rest.dto.EventTypeDto;
import info.nino.jpatron.annotiation.EntityClass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import user.api.rest.dto.UserDto;

import java.time.LocalDateTime;

@Getter
@Setter
@EntityClass(Event.class)
@Builder
public class EventDto {
    private Integer id;
    private String name;
    private String description;
    private EventTypeDto eventType;
    private LocalDateTime startDateTime;
    private LocalDateTime finishDateTime;
    private short maxParticipants;
    private EventFeeDto entryFee;
    private UserDto owner;
    private boolean isClosedEvent;
    private short status;
    private String location;

}
