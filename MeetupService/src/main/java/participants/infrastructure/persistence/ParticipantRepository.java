package participants.infrastructure.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import participants.domain.model.Participant;

@ApplicationScoped
public class ParticipantRepository implements PanacheRepository<Participant> {
}
