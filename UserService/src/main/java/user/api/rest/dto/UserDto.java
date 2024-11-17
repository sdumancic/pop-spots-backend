package user.api.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private Integer id;
    private String objectId;
    private String email;
    private String gender;
}
