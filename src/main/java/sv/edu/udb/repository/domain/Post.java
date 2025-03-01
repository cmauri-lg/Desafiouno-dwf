package sv.edu.udb.repository.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity //Anotacion para marcar que es una entidad de negocio
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MATERIA")
//MATERIA - Entidad del Negocio
public class Post {
    @Id //definicion del id (es una anotacion obligatoria si se usa entity)
    private Long id;
    @Column(nullable = false)
    private String nombre;
}



