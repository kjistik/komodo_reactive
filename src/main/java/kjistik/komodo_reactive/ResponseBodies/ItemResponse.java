package kjistik.komodo_reactive.ResponseBodies;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemResponse {
    UUID id;
    String unit;
    String name;
    boolean active;
}
