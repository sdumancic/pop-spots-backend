package participants.service;

import events.api.rest.dto.EventDto;
import events.service.EventMapper;
import participants.api.rest.dto.InviteParticipantRequestDto;
import participants.api.rest.dto.ParticipantDto;
import participants.domain.model.Participant;
import user.api.rest.dto.UserDto;
import user.service.UsersMapper;

public class ParticipantMapper {

    public static ParticipantDto toParticipantDto(Participant participant) {
        return ParticipantDto.builder()
                .id(participant.getId())
                .event(EventMapper.toEventDto(participant.getEvent()))
                .user(UsersMapper.toUserDto(participant.getUser()))
                .invitedByUser(UsersMapper.toUserDto(participant.getInvitedByUser()))
                .sentTs(participant.getSendTs())
                .responseId(participant.getResponseId())
                .responseTs(participant.getResponseTs())
                .responseMessage(participant.getResponseMessage())
                .build();
    }

    public static Participant toParticipant(ParticipantDto dto) {
        Participant participant = new Participant();
        participant.setId(dto.getId());
        participant.setEvent(EventMapper.toEvent(dto.getEvent()));
        participant.setUser(UsersMapper.toUsers(dto.getInvitedByUser()));
        participant.setInvitedByUser(UsersMapper.toUsers(dto.getUser()));
        participant.setSendTs(dto.getSentTs());
        participant.setResponseId(dto.getResponseId());
        participant.setResponseTs(dto.getResponseTs());
        participant.setResponseMessage(dto.getResponseMessage());

        return participant;
    }

    public static Participant toParticipant(InviteParticipantRequestDto dto, UserDto invitedByUser) {
        Participant participant = new Participant();
        participant.setEvent(EventMapper.toEvent(EventDto.builder().id(dto.getEventId()).build()));
        participant.setUser(UsersMapper.toUsers(UserDto.builder().id(dto.getUserId()).build()));
        participant.setInvitedByUser(UsersMapper.toUsers(invitedByUser));
        return participant;
    }
}

