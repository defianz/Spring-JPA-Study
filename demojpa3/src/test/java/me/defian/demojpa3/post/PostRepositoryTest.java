package me.defian.demojpa3.post;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(PostRepositoryTestConfig.class)
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void querydsl(){
        Post post = new Post();
        post.setTitle("Hibernate");
        postRepository.save(post.publish());

        Predicate predicate = QPost.post.title.containsIgnoreCase("Hi");
        Optional<Post> one = postRepository.findOne(predicate);
        assertTrue(!one.isEmpty());
    }

//    @Test
//    public void event(){
//
//        Post post = new Post();
//        post.setTitle("Event");
//        PostPublishedEvent event = new PostPublishedEvent(post);
//        applicationContext.publishEvent(event);
//    }
//
//
//    @Test
//    public void crud(){
////        postRepository.findMyPost();
//        Post post = new Post();
//        post.setTitle("Hibernate");
//        assertFalse(postRepository.contains(post));
//
//        postRepository.save(post.publish());
//
//        assertTrue(postRepository.contains(post));
//
////        postRepository.findMyPost();
//
//        postRepository.delete(post);
//        postRepository.flush();
//    }

}