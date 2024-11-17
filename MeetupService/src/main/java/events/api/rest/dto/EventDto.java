package events.api.rest.dto;

import eventfees.api.rest.dto.EventFeeDto;
import eventtypes.api.rest.dto.EventTypeDto;
import lombok.Getter;
import lombok.Setter;
import user.api.rest.dto.UserDto;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventDto {
    private Long id;
    private String name;
    private String description;
    private EventTypeDto eventType;
    private LocalDateTime startDateTime;
    private LocalDateTime finishDateTime;
    private int maxParticipants;
    private EventFeeDto entryFee;
    private UserDto owner;
    private boolean isClosedEvent;
    private int status;
    private String location;

}
