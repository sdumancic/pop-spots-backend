package events.service;

import common.utils.BooleanUtils;
import common.utils.GeometryUtil;
import eventfees.service.EventFeeMapper;
import events.api.rest.dto.CreateEventDto;
import events.api.rest.dto.EventDto;
import events.domain.model.Event;
import eventtypes.service.EventTypeMapper;
import user.api.rest.dto.UserDto;

public class EventMapper {

    public static EventDto toEventDto(Event event, UserDto userDto) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .eventType(EventTypeMapper.toEventTypeDto(event.getEventType()))
                .startDateTime(event.getStartDateTime())
                .finishDateTime(event.getFinishDateTime())
                .maxParticipants(event.getMaxParticipants())
                .entryFee(EventFeeMapper.toEventFeeDto(event.getEventFee()))
                .owner(userDto)
                .isClosedEvent(BooleanUtils.fromShort(event.getIsClosedEvent()))
                .status(event.getStatus())
                .location(GeometryUtil.toWKT(event.getLocation()))
                .build();
    }

    public static Event toEvent(EventDto dto, UserDto userDto) {
        Event event = new Event();
        event.setId(dto.getId());
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setEventType(EventTypeMapper.toEventType(dto.getEventType()));
        event.setStartDateTime(dto.getStartDateTime());
        event.setFinishDateTime(dto.getFinishDateTime());
        event.setMaxParticipants(dto.getMaxParticipants());
        event.setIsClosedEvent(BooleanUtils.fromBoolean(dto.isClosedEvent()));
        event.setStatus(dto.getStatus());
        event.setLocation(GeometryUtil.stringToGeometry(dto.getLocation()));
        event.setOwnerId(userDto.getId());
        event.setEventFee(EventFeeMapper.toEventFee(dto.getEntryFee()));
        return event;
    }

    public static Event toEvent(CreateEventDto dto, UserDto userDto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setEventType(EventTypeMapper.toEventType(dto.getEventType()));
        event.setStartDateTime(dto.getStartDateTime());
        event.setFinishDateTime(dto.getFinishDateTime());
        event.setMaxParticipants(dto.getMaxParticipants());
        event.setIsClosedEvent(BooleanUtils.fromBoolean(dto.isClosedEvent()));
        event.setStatus(dto.getStatus());
        event.setLocation(GeometryUtil.stringToGeometry(dto.getLocation()));
        event.setOwnerId(userDto.getId());
        event.setEventFee(EventFeeMapper.toEventFee(dto.getEntryFee()));
        return event;
    }
}
