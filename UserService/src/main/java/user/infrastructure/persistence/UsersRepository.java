package user.infrastructure.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import user.domain.model.Users;

import java.util.Optional;

@ApplicationScoped
public class UsersRepository implements PanacheRepository<Users> {

    public Users findByObjectId(String objectId) {
        Optional<Users> optional = find("objectId", objectId).firstResultOptional();
        return optional.orElseThrow(NotFoundException::new);
    }

    public Users findByEmail(String email) {
        Optional<Users> optional = find("email", email).firstResultOptional();
        return optional.orElseThrow(NotFoundException::new);
    }
}
