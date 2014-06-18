package ru.kpfu.it.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.forum.model.Post;
import ru.kpfu.it.forum.model.Topic;
import ru.kpfu.it.forum.repository.PostRepository;
import ru.kpfu.it.forum.repository.TopicRepository;

import java.util.List;

@Controller
public class GetPostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TopicRepository topicRepository;

    @RequestMapping(value = {"/get_posts/{id}"}, method = RequestMethod.GET)
    public @ResponseBody List<Post> getPosts(@PathVariable Long id){
        Topic topic = topicRepository.findOne(id);
        List<Post> posts = topic.getPosts();
        return posts;
    }
}
