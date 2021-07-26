package me.defian.commoneweb.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void save(){
        Post post = new Post();
        post.setTitle("jpa");
        Post savePost = postRepository.save(post);

        assertTrue(entityManager.contains(post));
        assertTrue(entityManager.contains(savePost));
        assertTrue(savePost == post);

        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("hibernate");
        Post updatedPost = postRepository.save(postUpdate);

        updatedPost.setTitle("hi");

        assertTrue(entityManager.contains(updatedPost));
        assertFalse(entityManager.contains(postUpdate));
        assertFalse(updatedPost==postUpdate);

        List<Post> all = postRepository.findAll();
        assertTrue(all.size()==1);
    }

    @Test
    public void findByTitleStartsWith(){
        savePost();

        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        assertEquals(all.size(),1);

    }

    @Test
    public void findByTitle(){
        savePost();

//        List<Post> all = postRepository.findByTitle("Spring", Sort.by("title"));
        List<Post> all = postRepository.findByTitle("Spring", JpaSort.unsafe("LENGTH(title)"));
        assertEquals(all.size(),1);

    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring Data JPA");
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Test
    public  void updateTitle(){
        Post spring = savePost();
        String hibernate = "hibernate";
        int update = postRepository.updateTitle(hibernate,spring.getId());
        assertEquals(update,1);

        Optional<Post> byId = postRepository.findById(spring.getId());
        System.out.println("===================");
        System.out.println(byId.get().getTitle());
        assertEquals(byId.get().getTitle(),hibernate);
    }


}