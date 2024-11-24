package participants.api.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import events.api.rest.dto.EventDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import user.api.rest.dto.UserDto;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ParticipantDto {
    private Integer id;
    private EventDto event;
    private UserDto user;
    private UserDto invitedByUser;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime sentTs;
    private short responseId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime responseTs;
    private String responseMessage;

    @Override
    public String toString() {
        return "ParticipantDto{" +
                "id=" + id +
                ", event=" + event +
                ", user=" + user +
                ", invitedByUser=" + invitedByUser +
                ", sentTs=" + sentTs +
                ", responseId=" + responseId +
                ", responseTs=" + responseTs +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
