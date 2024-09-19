package kjistik.komodo_reactive.Repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Unit;

public interface UnitRepository extends ReactiveCrudRepository<Unit, Long>{
    
}
