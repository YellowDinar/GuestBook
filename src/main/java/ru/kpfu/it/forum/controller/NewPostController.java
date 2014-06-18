package ru.kpfu.it.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.forum.model.Post;
import ru.kpfu.it.forum.repository.PostRepository;
import ru.kpfu.it.forum.repository.TopicRepository;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class NewPostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    TopicRepository topicRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/topic/posts/new")
    @Transactional(noRollbackFor = Exception.class)
    public @ResponseBody void create(@Valid Post post, BindingResult result){
        post.setCreatedAt(new Date());
        post.setUpdatedAt(post.getCreatedAt());
//        post.setTopic(topicRepository.findOne(id));
        postRepository.save(post);
    }

}