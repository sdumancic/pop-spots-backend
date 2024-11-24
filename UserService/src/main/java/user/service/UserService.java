package user.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.NotFoundException;
import user.api.rest.dto.UserDto;
import user.domain.model.Users;
import user.infrastructure.persistence.UsersRepository;

@ApplicationScoped
public class UserService {

    @Inject
    UsersRepository usersRepository;

    public UserDto getById(Long id) {
        try {
            Users user = usersRepository.findById(id);
            return UsersMapper.toUserDto(user);
        } catch (NotFoundException ex) {
            throw new ForbiddenException(String.format("User with id %s does not exists", id));
        }
    }

    public UserDto getUserByObjectId(String objectId) {
        try {
            Users user = usersRepository.findByObjectId(objectId);
            return UsersMapper.toUserDto(user);
        } catch (NotFoundException ex) {
            throw new ForbiddenException(String.format("User %s does not exists", objectId));
        }
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
