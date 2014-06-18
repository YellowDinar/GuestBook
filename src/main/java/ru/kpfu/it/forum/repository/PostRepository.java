package ru.kpfu.it.forum.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.kpfu.it.forum.model.Post;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    List<Post> findByTitleLikeIgnoreCase(String title);
}
