package kjistik.komodo_reactive.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kjistik.komodo_reactive.Models.Item;
import kjistik.komodo_reactive.RequestBodies.IdRequest;
import kjistik.komodo_reactive.RequestBodies.Page;
import kjistik.komodo_reactive.RequestBodies.PageLenght;
import kjistik.komodo_reactive.ResponseBodies.ItemResponse;
import kjistik.komodo_reactive.Services.Item.ItemService;
import kjistik.komodo_reactive.Utils.Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/item")

public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/pages")
    Mono<Integer> getPages(@RequestBody PageLenght lenght) {
        return service.getCountPages(lenght.lenght);
    }

    @PostMapping("/create")
    Mono<Item> createItem(@RequestBody Item newItem) {
        newItem.setId(Utils.generateUUID());
        return service.createItem(newItem);
    }

    @GetMapping("/get/single")
    Mono<ItemResponse> getSingleItem(@RequestBody IdRequest id) {
        return service.getSingleItem(id.getId());
    }

    @GetMapping("/get")
    Flux<ItemResponse> getAllItems(@RequestBody Page page) {
        return service.getAllItems(page.getLenght(), page.getOffset());
    }
}
