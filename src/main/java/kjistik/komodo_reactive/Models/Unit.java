package kjistik.komodo_reactive.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//Modelado en concordancia con el DER en docs

@Table("unit")
public class Unit {
    @Id
    @Column("id")
    Long id;
    @Column("name")
    String name;
}