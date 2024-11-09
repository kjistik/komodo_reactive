package kjistik.komodo_reactive.Repositories;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import kjistik.komodo_reactive.Models.Price_history;

public interface Price_historyRepository extends ReactiveCrudRepository<Price_history, UUID> {
}
