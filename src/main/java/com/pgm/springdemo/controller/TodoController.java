package com.pgm.springdemo.controller;

import com.pgm.springdemo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("/todo")
public class TodoController {

    //localhost:8080/todo/list 이거랑 똑같다.
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(){
        log.info("list");
    }
    //@RequestMapping(value = "/register", method = RequestMethod.GET) - 이렇게 길게 적는것보다 getMapping하면 된다.
    @GetMapping("/register")
    public void registerGet(){
        log.info("registerGet");
    }
    //@RequestMapping(value = "/register", method = RequestMethod.POST) - 위와 같은 이유
    @PostMapping("/register")
    public String registerPost(@ModelAttribute TodoDTO todoDTO, Model model) {
        //model에 객체를 담아서 보낸다.
        log.info("registerPost");
        //model.addAttribute("dto", todoDTO);
        return "redirect:/todo/list";
    }
}
