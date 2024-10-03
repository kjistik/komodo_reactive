package kjistik.komodo_reactive.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

//Modelado en concordancia con el DER en docs
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("unit")
public class Unit {
    @Id
    @Column("id")
    UUID id;
    @Column("name")
    String name;

}   