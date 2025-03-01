package sv.edu.udb.repository.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity //Anotacion para marcar que es una entidad de negocio


public class Post {
    @Id //definicion del id (es una anotacion obligatoria si se usa entity)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDate postDate;

    public Post(Long id, String title, LocalDate postDate) {
        this.id = id;
        this.title = title;
        this.postDate = postDate;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }
}



