package kjistik.komodo_reactive.Repositories;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Unit;
import reactor.core.publisher.Mono;

public interface UnitRepository extends ReactiveCrudRepository<Unit, UUID> {

    @Query("INSERT INTO unit (id, name) VALUES (:id, :name)")
    Mono<Unit> saveUnit(UUID id, String name);

    @Query("SELECT id FROM unit WHERE id=:id")
    Mono<Integer> checkUnit(UUID id);

    @Query("UPDATE unit SET name=:name WHERE id=:id")
    Mono<Unit> editUnit(UUID id, String name);

    @Query("DELETE FROM unit WHERE id=:id")
    void deleteUnit(UUID id);
}
