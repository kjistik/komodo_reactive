package kjistik.komodo_reactive.Services.Unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kjistik.komodo_reactive.Models.Unit;
import kjistik.komodo_reactive.Repositories.UnitRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import kjistik.komodo_reactive.Utils.Utils;

@Service
public class UnitServiceImp implements UnitService {

    @Autowired
    UnitRepository repo;

    @Override
    public Flux<Unit> getAll() {
        return repo.findAll();
    }

    @Override
    public Mono<Unit> newUnit(Unit newUnit) {
        newUnit.setId(Utils.generateUUID());
        return repo.saveUnit(newUnit.getId(), newUnit.getName());
    }

}
