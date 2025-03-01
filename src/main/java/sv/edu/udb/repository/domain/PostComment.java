package sv.edu.udb.repository.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Entity //Anotacion para marcar que es una entidad de negocio
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

//Entidad del Negocio - ALUMNO
public class PostComment {

    @Id
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String Apellido;

    @ManyToOne(fetch = FetchType.LAZY) //Relacion de Muchos a uno
    @JoinColumn(name = "id_materia") //Definimos el nombre de la llave foranea
    private Post post;

}
