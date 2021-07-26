package me.defian.commoneweb.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    public void getComment(){

        Post post = new Post();
        post.setTitle("JPA");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("comment");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        commentRepository.save(comment);

        commentRepository.findByPost_Id(savedPost.getId(), CommentSummary.class).forEach(c -> {
            System.out.println("=================");
            System.out.println(c.getVotes());
        });


//        commentRepository.getById(1l);
//        System.out.println("===================");
//        commentRepository.findById(1l);
//        commentRepository.findByPost_Id(1l);
    }



    @Test
    public void qbe(){
        Comment probe = new Comment();
        probe.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withIgnorePaths("up","down");
        Example<Comment> example = Example.of(probe,exampleMatcher);

        commentRepository.findAll(example);

    }

}