package kjistik.komodo_reactive.Repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Item;
import kjistik.komodo_reactive.ResponseBodies.ItemResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemRepository extends ReactiveCrudRepository<Item, UUID> {

    @Query("SELECT COUNT(*) FROM item")
    Mono<Integer> getTotalEntries();

    @Query("INSERT INTO item (id, unit_id, name) VALUES (:id, :unit, :name)")
    Mono<Item> createItem(UUID id, UUID unit, String name);

    @Query("SELECT item.id, unit.name AS unit, item.name FROM item INNER JOIN unit ON item.unit_id=unit.id LIMIT :limit OFFSET :offset")
    Flux<ItemResponse> getAllItems(int limit, int offset);
}
