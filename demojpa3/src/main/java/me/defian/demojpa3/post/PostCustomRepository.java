package me.defian.demojpa3.post;

import java.util.List;

public interface PostCustomRepository<T> {

    List<T> findMyPost();

    void delete(T entity);
}
