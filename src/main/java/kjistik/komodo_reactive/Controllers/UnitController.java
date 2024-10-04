package kjistik.komodo_reactive.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kjistik.komodo_reactive.Models.Unit;
import kjistik.komodo_reactive.RequestBodies.IdRequest;
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

    @PutMapping("/edit")
    Mono<Unit> editUnit(@RequestBody Unit newUnit) {
        return service.editUnit(newUnit);
    }

    @DeleteMapping("/delete")
    void deleteUnit(@RequestBody IdRequest id) {
        service.deleteUnit(id);
    }
}
