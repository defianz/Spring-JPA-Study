package me.defian.demospringdata;

import com.sun.istack.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {


    @Autowired
    CommentRepository commentRepository;

    @Test
    public void curd() throws ExecutionException, InterruptedException, TimeoutException {
//        Comment comment = new Comment();
//        comment.setComment("Hello Wolrd");
//        commentRepository.save(comment);
//
//        List<Comment> all = commentRepository.findAll();
//        assertTrue(all.size()==1);
//
//        assertTrue(commentRepository.count()==1);
//
//        Optional<Comment> byId = commentRepository.findById(100l);
//        assertTrue(byId.isEmpty());
//        comment.setComment("spring data jpa");
//        comment.setLikeCount(15);
//        commentRepository.save(comment);

        this.createComment(100);
        this.createComment(55);
        commentRepository.flush();

        List<Comment> all = commentRepository.findAll();



//        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeContGreaterThan("spring",10);
//        List<Comment> comments = commentRepository.findAll();
//        assertTrue(comments.size()==1);

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"LikeCount"));

//        Page<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("Spring",pageRequest);
//        try(
//                Stream<Comment> commets = commentRepository.findByCommentContainsIgnoreCase("Spring",pageRequest);
//        ){
//            Comment firstCommnet = commets.findFirst().get();
//            assertTrue(firstCommnet.getLikeCount() == 100);
//        }

        ListenableFuture<List<Comment>> future = commentRepository.findByCommentContainsIgnoreCase("Spring");
        System.out.println("==============");
        System.out.println("is done? " + future.isDone());

//        List<Comment> comments = future.get(1000, TimeUnit.MILLISECONDS);

        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable);
            }

            @Override
            public void onSuccess(@Nullable List<Comment> comments) {
                System.out.println("================");
                System.out.println(future.isDone());
                System.out.println("comments.size() = " + comments.size());
                comments.forEach(System.out::println);
            }
        });



        Thread.sleep(500);


//        assertEquals(comments.getNumberOfElements(),2);
//        comments.forEach(System.out::println);

//        commentRepository.save(null);
    }

    private void createComment(int likeCount){
        Comment comment = new Comment();
        comment.setLikeCount(likeCount);
        comment.setComment("spring data jpa");
        commentRepository.save(comment);
    }

}