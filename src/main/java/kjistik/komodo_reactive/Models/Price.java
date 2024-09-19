package kjistik.komodo_reactive.Models;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//Modelado en concordancia con el DER en docs

@Table("price")
public class Price {
    @Id
    @Column("id")
    Long id;
    @Column("variety")
    Long variety;
    @Column("value")
    float value;
    @Column("since")
    Date since;
}
