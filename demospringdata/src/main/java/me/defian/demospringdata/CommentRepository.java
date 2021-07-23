package me.defian.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long> {

//    Comment save(Comment comment);
//
    List<Comment> findAll();

    void flush();

//    @Query("SELECT c FROM Comment AS c")
//    List<Comment> findByCommentContainsIgnoreCaseAndLikeContGreaterThan (String keyword, int likecount);

//    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

    @Async
    ListenableFuture<List<Comment>> findByCommentContainsIgnoreCase(String keyword);
}
