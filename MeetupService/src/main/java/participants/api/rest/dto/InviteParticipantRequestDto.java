package participants.api.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InviteParticipantRequestDto {
    private Integer eventId;
    private Integer userId;
}
