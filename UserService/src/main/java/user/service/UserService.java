package user.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import user.api.rest.dto.UserDto;
import user.domain.model.Users;
import user.infrastructure.persistence.UsersRepository;

@ApplicationScoped
public class UserService {

    @Inject
    UsersRepository usersRepository;

    public UserDto getUserByObjectId(String objectId) {
        Users user = usersRepository.findByObjectId(objectId);
        return UsersMapper.toUserDto(user);
    }

    public UserDto createUser(String email, String objectId, String gender) {
        Users user = new Users();
        user.setEmail(email);
        user.setGender(gender);
        user.setObjectId(objectId);
        usersRepository.persist(user);
        Users createdUser = usersRepository.findById(user.getId().longValue());
        return UsersMapper.toUserDto(createdUser);
    }
}
