package ru.kpfu.it.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.forum.model.Topic;
import ru.kpfu.it.forum.repository.TopicRepository;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("topic/new")
public class NewTopicController {

    @Autowired
    TopicRepository topicRepository;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void create(@Valid Topic topic, BindingResult result){
        topic.setCreatedAt(new Date());
        topic.setUpdatedAt(topic.getCreatedAt());
        topicRepository.save(topic);
    }
}
