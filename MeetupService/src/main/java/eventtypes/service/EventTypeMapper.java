package eventtypes.service;

import common.utils.BooleanUtils;
import eventtypes.api.rest.dto.EventTypeDto;
import eventtypes.domain.model.EventType;

public class EventTypeMapper {

    public static EventTypeDto toEventTypeDto(EventType eventType) {
        return EventTypeDto.builder()
                .id(eventType.getId())
                .name(eventType.getName())
                .description(eventType.getDescription())
                .active(BooleanUtils.fromShort(eventType.getActive()))
                .build();
    }

    public static EventType toEventType(EventTypeDto dto) {
        EventType eventType = new EventType();
        eventType.setId(dto.getId());
        eventType.setName(dto.getName());
        eventType.setDescription(dto.getDescription());
        eventType.setActive(BooleanUtils.fromBoolean(dto.getActive()));
        return eventType;
    }
}
