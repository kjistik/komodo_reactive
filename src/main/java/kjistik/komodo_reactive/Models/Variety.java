package kjistik.komodo_reactive.Models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//Modelado en concordancia con el DER en docs
@Table("variety")
public class Variety {
    
    @Id
    @Column("id")
    UUID id;
    
    @Column("price_history")
    UUID price_history;
    
    @Column("active")
    boolean active;
    
    @Column("amount")
    float amount;
    
    @Column("color")
    String color;
    
    @Column("name")
    String name;
}
