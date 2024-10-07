package kjistik.komodo_reactive.Services.Unit;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kjistik.komodo_reactive.Models.Unit;
import kjistik.komodo_reactive.Repositories.UnitRepository;
import kjistik.komodo_reactive.RequestBodies.IdRequest;
import kjistik.komodo_reactive.Utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Override
    public Mono<Integer> checkUnit(UUID id) {
        return repo.checkUnit(id);
    }

    @Override
    public Mono<Unit> editUnit(Unit newUnit) {
        if (repo.checkUnit(newUnit.getId()) == null) {
            return null;
        } else {
            repo.editUnit(newUnit.getId(), newUnit.getName());
            return repo.findById(newUnit.getId());
        }
    }

    @Override
    public void deleteUnit(IdRequest id) {
        repo.deleteById(id.getId());
    }

    @Override
    public Mono<Unit> getSingleUnit(UUID id) {
        return repo.findById(id);
    }
}
