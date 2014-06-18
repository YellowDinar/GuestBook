package ru.kpfu.it.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.it.forum.model.Topic;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findByTitleLikeIgnoreCase(String title);
}
