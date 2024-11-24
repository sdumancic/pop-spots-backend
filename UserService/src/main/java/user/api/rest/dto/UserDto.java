package user.api.rest.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserDto {
    private Integer id;
    private String objectId;
    private String email;
    private String gender;
}
