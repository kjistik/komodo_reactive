package kjistik.komodo_reactive.Services.Unit;

import java.util.UUID;

import kjistik.komodo_reactive.Models.Unit;
import kjistik.komodo_reactive.RequestBodies.IdRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UnitService {
    Flux<Unit> getAll();

    Mono<Unit> newUnit(Unit newUnit);

    Mono<Integer> checkUnit(UUID id);

    Mono<Unit> editUnit(Unit newUnit);

    void deleteUnit(IdRequest id);
}
