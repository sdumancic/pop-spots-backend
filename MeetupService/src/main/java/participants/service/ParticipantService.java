package participants.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import participants.api.rest.dto.InviteParticipantRequestDto;
import participants.api.rest.dto.ParticipantDto;
import participants.domain.model.Participant;
import participants.infrastructure.persistence.ParticipantRepository;
import user.api.rest.dto.UserDto;
import user.service.UserService;

@ApplicationScoped
@Slf4j
public class ParticipantService {
    @Inject
    ParticipantRepository participantRepository;

    @Inject
    UserService userService;

    public ParticipantDto getById(Long id, Integer userId) {
        Participant participant = participantRepository.findById(id);
        return ParticipantMapper.toParticipantDto(participant);
    }

    @Transactional
    public ParticipantDto inviteParticipant(InviteParticipantRequestDto dto, UserDto userDto) {
        Participant participant = ParticipantMapper.toParticipant(dto, userDto);
        participantRepository.persist(participant);
        return ParticipantMapper.toParticipantDto(participant);
    }

    @Transactional
    public void disinviteParticipant() {
    }

    @Transactional
    public void acceptInvitation() {
    }

    @Transactional
    public void declineInvitation() {
    }
}
