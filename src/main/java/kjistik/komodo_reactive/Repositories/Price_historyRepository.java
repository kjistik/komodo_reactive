package kjistik.komodo_reactive.Repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Price_history;
import java.util.UUID;
public interface Price_historyRepository extends ReactiveCrudRepository<Price_history, UUID>{
    
}
