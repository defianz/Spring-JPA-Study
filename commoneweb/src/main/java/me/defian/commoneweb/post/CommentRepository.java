package me.defian.commoneweb.post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment>,
        QueryByExampleExecutor<Comment> {

    @EntityGraph(attributePaths = "post")
    Comment getById(Long id);

    List<CommentSummary> findByPost_Id(Long id);

    @Transactional
    <T> List<T> findByPost_Id(Long id, Class<T> type);
}
