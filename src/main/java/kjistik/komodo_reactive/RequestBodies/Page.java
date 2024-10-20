package kjistik.komodo_reactive.RequestBodies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    int page;
    int lenght;

    public int getOffset() {
        return (page - 1) * lenght;
    }
}
