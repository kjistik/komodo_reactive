package kjistik.komodo_reactive.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//Modelado en concordancia con el DER en docs
@Table("item")
public class Item {

    @Id
    @Column("id")
    Long id;
    @Column("unit_id")
    Long unit_id;
    @Column("name")
    String name;
}
