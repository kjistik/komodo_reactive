package kjistik.komodo_reactive.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kjistik.komodo_reactive.Models.Unit;
import kjistik.komodo_reactive.Services.Unit.UnitServiceImp;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/units")
public class UnitController {
    @Autowired
    UnitServiceImp service;

    @GetMapping("/get")
    Flux<Unit> getAll() {
        return service.getAll();
    }

    @PostMapping("/new")
    Mono<Unit> newUnit(@RequestBody Unit newUnit) {
        return service.newUnit(newUnit);
    }
}
