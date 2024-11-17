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

    @Query("SELECT id FROM item WHERE id=:id")
    Mono<Integer> checkItem(UUID id);

    @Query("INSERT INTO item (id, unit_id, name, active) VALUES (:id, :unit_id, :name, :active)")
    Mono<Item> createItem(UUID id, UUID unit_id, String name, boolean active);

    @Query("UPDATE item SET unit_id=:unit_id, name=:name, active = :active where id=:id")
    Mono<Item> editItem(UUID id, UUID unit_id, String name, boolean active);

    @Query("SELECT item.id, unit.name AS unit, item.name FROM item INNER JOIN unit ON item.unit_id=unit.id WHERE active=true LIMIT :limit OFFSET :offset ")
    Flux<ItemResponse> getAllItems(int limit, int offset);

    @Query("UPDATE item SET active=:active WHERE id=:id")
    Mono<Integer> deleteItem(UUID id);
}
