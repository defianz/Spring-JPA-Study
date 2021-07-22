package me.defian.demospringdata;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

//    @PersistenceContext
//    EntityManager entityManager;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        postRepository.findAll().forEach(System.out::println);
//        Account account = new Account();
//        account.setName("defian");
//        account.setPassword("jpa");
//
//        Study study = new Study();
//        study.setName("Spring DATA JPA");
////        study.setOwner(account);
//        account.addStudy(study);


//        session.save(account);
//        session.save(study);

//        entityManager.persist(account);
//
//        Post post = new Post();
//        post.setTitle("Spring Data JPA gogo");
//        Comment comment = new Comment();
//        comment.setComment("82828 ㄱ ㄱ");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("곧 보여줍니다");
//        post.addComment(comment1);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(post);

//        Post post2 = session.get(Post.class,1l);
//        System.out.println("post2.getTitle() = " + post2.getTitle());
//        Comment comment2 = session.get(Comment.class,2l);
//        System.out.println("comment2.getTitle() = " + comment2.getTitle());
    }
}
