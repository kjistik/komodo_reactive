package kjistik.komodo_reactive.Models;

import java.sql.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//Modelado en concordancia con el DER en docs

@Table("price")
public class Price {
    @Id
    @Column("id")
    UUID id;
    @Column("variety")
    UUID variety;
    @Column("value")
    float value;
    @Column("since")
    Date since;

    public void generateUUID() {
        this.id = UUID.randomUUID();
    }
}
