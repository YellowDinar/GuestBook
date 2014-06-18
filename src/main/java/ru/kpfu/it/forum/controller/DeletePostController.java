package ru.kpfu.it.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.it.forum.repository.PostRepository;

@Controller
@RequestMapping("topic/posts/{id}/delete")
public class DeletePostController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody void delete(@PathVariable Long id, Model model){
        if(postRepository.exists(id)){
            postRepository.delete(id);
        }
    }
}