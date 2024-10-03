package kjistik.komodo_reactive.Repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Variety;
import java.util.UUID;

public interface VarietyRepository extends ReactiveCrudRepository<Variety, UUID> {

}
