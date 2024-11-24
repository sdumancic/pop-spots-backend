package events.service;

import events.api.rest.dto.EventDto;
import events.domain.model.Event;
import events.infrastructure.persistence.EventRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ForbiddenException;
import lombok.extern.slf4j.Slf4j;
import user.api.rest.dto.UserDto;
import user.service.UserService;

@ApplicationScoped
@Slf4j
public class EventService {
    @Inject
    EventRepository eventRepository;

    @Inject
    UserService userService;

    public EventDto getById(Long id, Integer userId) {
        Event event = eventRepository.findById(id);
        if (event.getOwnerId().compareTo(userId) != 0) {
            throw new ForbiddenException("User is not an owner of event");
        }
        UserDto userDto = userService.getById(userId.longValue());
        return EventMapper.toEventDto(event, userDto);
    }

    public void createEvent() {
    }

    public void updateEvent() {
    }

    public void deleteEvent() {
    }

    public void inviteParticipant() {
    }

    public void disinviteParticipant() {
    }
}
