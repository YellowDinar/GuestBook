package ru.kpfu.it.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.forum.model.Topic;
import ru.kpfu.it.forum.repository.TopicRepository;

import java.util.List;

@Controller
public class ShowTopicController {

    @Autowired
    TopicRepository topicRepository;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String showAll(Model model){
        return "/html/index.html";
    }

    @RequestMapping(value = {"/get_topics"}, method = RequestMethod.GET)
    public @ResponseBody List<Topic> getTopics(){
        List<Topic> allTopics = (List<Topic>) topicRepository.findAll();
        return allTopics;
    }
}
