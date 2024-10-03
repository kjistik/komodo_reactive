package kjistik.komodo_reactive.Repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Item;
import java.util.UUID;
public interface ItemRepository extends ReactiveCrudRepository<Item, UUID> {

}
