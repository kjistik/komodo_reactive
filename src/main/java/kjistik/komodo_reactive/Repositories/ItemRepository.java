package kjistik.komodo_reactive.Repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Item;

public interface ItemRepository extends ReactiveCrudRepository<Item, Long> {

}
