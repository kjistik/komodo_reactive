package kjistik.komodo_reactive.Services.Item;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kjistik.komodo_reactive.Models.Item;
import kjistik.komodo_reactive.Repositories.ItemRepository;
import kjistik.komodo_reactive.Repositories.UnitRepository;
import kjistik.komodo_reactive.RequestBodies.IdRequest;
import kjistik.komodo_reactive.ResponseBodies.ItemResponse;
import kjistik.komodo_reactive.Services.Unit.UnitService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService implements ItemServiceInt {

    @Autowired
    ItemRepository repo;

    @Autowired
    UnitRepository unitRepo;

    @Autowired
    UnitService unitService;

    public Mono<Integer> getCountPages(int amount) {
        return repo.getTotalEntries().map(totalEntries -> {
            int pages = totalEntries / amount;
            if (totalEntries % amount != 0) {
                pages++;
            }
            return pages;
        });
    }

    @Override
    public Mono<Item> createItem(Item item) {
        if (unitRepo.checkUnit(item.getUnit_id()) != null) {
            return repo.createItem(item.getId(), item.getUnit_id(), item.getName(), item.isActive());
        } else {
            System.out.println("no existe esa unidad, pa");
            return null;
        }
    }

    @Override
    public Mono<ItemResponse> getSingleItem(UUID id) {
        return repo.findById(id)
                .flatMap(item -> {
                    return unitService.getSingleUnit(item.getUnit_id())
                            .map(unit -> new ItemResponse(item.getId(), unit.getName(), item.getName(),
                                    item.isActive()));
                });
    }

    @Override
    public Flux<ItemResponse> getAllItems(int limit, int offset) {
        return repo.getAllItems(limit, offset);
    }

    @Override
    public Mono<Item> editItem(Item item) {
        if (repo.checkItem(item.getId()) == null) {
            return null;
        } else {
            repo.editItem(item.getId(), item.getUnit_id(), item.getName(), item.isActive());
            return repo.findById(item.getId());
        }
    }

    @Override
    public Mono<Integer> deleteItem(IdRequest id) {
        return repo.deleteItem(id.getId());
    }

}
// lo echaron de la vida