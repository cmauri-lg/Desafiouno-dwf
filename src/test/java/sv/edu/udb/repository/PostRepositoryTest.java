package sv.edu.udb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import sv.edu.udb.repository.domain.Post;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void shouldHasOnePost_When_FindAll() {
        final List<Post> actualPostList = postRepository.findAll();
        assertNotNull(actualPostList);
    }
    @Test
    void shouldGetPost_When_IdExist() {
        Long expectedId = 1L;
        final Post actualPost = postRepository.findById(expectedId);
        assertNotNull(actualPost);
        assertEquals(expectedId, actualPost.getId());
    }
    @Test
    @Transactional
    void shouldSavePost_When_PostIsNew() {
        //Se utiliza @Transactional, porque estamos
        //realizando dos operaciones de modificado
        //de datos al mismo tiempo entonces es necesario
        //mantener la transaccion consistente con las operaciones
        final Long expectedId = 2L;
        final String expectedTitle = "Estadistica";
        final Post newPost = Post
                .builder()
                .id(expectedId)
                .nombre(expectedTitle)
                .build();
        postRepository.save(newPost);
        final Post actualPost = postRepository.findById(expectedId);
        assertNotNull(actualPost);
        assertEquals(expectedId, actualPost.getId());
        assertEquals(expectedTitle, actualPost.getNombre());
        //Despues de comprobar que el post con Id 2 existe
        //lo borramos para mantener consistencia de los datos y los test cases
        postRepository.delete(newPost); //deleting
    }

    @Test
    @Transactional
    void shouldDeletePost_When_PostExist() {
        final Long expectedId = 3L;
        final String expectedTitle = "Deleted";
        final Post newPost = Post
                .builder()
                .id(expectedId)
                .nombre(expectedTitle)
                .build();
        postRepository.save(newPost); //saving
        final Post actualPost = postRepository.findById(expectedId);
        assertNotNull(actualPost);
        postRepository.delete(newPost); //deleting
        final Post deletedPost = postRepository.findById(expectedId);
        assertNull(deletedPost);
    }

}
