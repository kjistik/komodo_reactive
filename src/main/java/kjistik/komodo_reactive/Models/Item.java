package kjistik.komodo_reactive.Models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//Modelado en concordancia con el DER en docs
@Table("item")
public class Item {

    @Id
    @Column("id")
    UUID id;
    @Column("unit_id")
    UUID unit_id;
    @Column("name")
    String name;
}
