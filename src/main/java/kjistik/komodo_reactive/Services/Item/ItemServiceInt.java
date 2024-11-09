package kjistik.komodo_reactive.Services.Item;

import java.util.UUID;

import kjistik.komodo_reactive.Models.Item;
import kjistik.komodo_reactive.ResponseBodies.ItemResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemServiceInt {

    Mono<Integer> getCountPages(int amount);

    Mono<Item> createItem(Item item);

    Mono<ItemResponse> getSingleItem(UUID id);

    Flux<ItemResponse> getAllItems(int limit, int offset);
}