package kjistik.komodo_reactive.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//Modelado en concordancia con el DER en docs
@Table("price_history")
public class Price_history {
    @Id
    @Column("id")
    Long id;
    @Column("item_id")
    Long item_id;
}
