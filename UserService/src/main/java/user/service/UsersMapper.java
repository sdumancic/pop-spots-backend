package user.service;

import jakarta.enterprise.context.ApplicationScoped;
import user.api.rest.dto.UserDto;
import user.domain.model.Users;

@ApplicationScoped
public class UsersMapper {

    public static UserDto toUserDto(Users user) {
        return UserDto.builder()
                .email(user.getEmail())
                .gender(user.getGender())
                .id(user.getId())
                .objectId(user.getObjectId())
                .build();
    }

    public static Users toUsers(UserDto dto) {
        Users user = new Users();
        user.setId(dto.getId());
        user.setObjectId(dto.getObjectId());
        user.setEmail(dto.getEmail());
        user.setGender(dto.getGender());
        return user;
    }
}
