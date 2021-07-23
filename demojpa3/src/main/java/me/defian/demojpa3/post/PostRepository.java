package me.defian.demojpa3.post;


import me.defian.demojpa3.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends MyRepository<Post,Long>, QuerydslPredicateExecutor<Post> {
}
