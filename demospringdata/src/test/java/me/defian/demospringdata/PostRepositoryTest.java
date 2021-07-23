package me.defian.demospringdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    @Rollback(false)
    public void curdRepository(){
        //Given
        Post post = new Post();
        post.setTitle("Hello Spring Boot Common");

        // When
       assertSame(post.getId(),null);

        // Then
        Post newPost = postRepository.save(post);

        assertNotSame(newPost.getId(),null);

        // When
        List<Post> posts = postRepository.findAll();

        // Then
        assertSame(posts.size(),1);
        assertTrue(posts.contains(newPost));

        // When
        Page<Post> page = postRepository.findAll(PageRequest.of(0,10));
//        assertSame(page.getTotalElements(),1);
//        assertSame(page.getNumber(), 0);
//        assertSame(page.getSize(),10);
//        assertSame(page.getNumberOfElements(),1);

        long spring = postRepository.countByTitleContains("Spring");
        System.out.println("spring = " + spring);
        assertTrue(spring==1);

        // When
    }

}