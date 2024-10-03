package kjistik.komodo_reactive.Services.Unit;

import kjistik.komodo_reactive.Models.Unit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UnitService {
    Flux<Unit> getAll();

    Mono<Unit> newUnit(Unit newUnit);
}
