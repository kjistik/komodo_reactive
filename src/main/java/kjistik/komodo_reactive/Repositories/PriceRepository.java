package kjistik.komodo_reactive.Repositories;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Price;
public interface PriceRepository extends ReactiveCrudRepository<Price, UUID>{
    
}
