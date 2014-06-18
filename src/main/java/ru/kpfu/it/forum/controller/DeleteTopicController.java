package ru.kpfu.it.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.forum.repository.TopicRepository;

@Controller
@RequestMapping("topic/{id}/delete")
public class DeleteTopicController {

    @Autowired
    TopicRepository topicRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody void delete(@PathVariable Long id, Model model){
        if(topicRepository.exists(id)){
            topicRepository.delete(id);
        }
    }
}



