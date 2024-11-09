package kjistik.komodo_reactive.Models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Modelado en concordancia con el DER en docs
@Table("price_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price_history {
    @Id
    @Column("id")
    UUID id;
    @Column("item_id")
    UUID item_id;
}
