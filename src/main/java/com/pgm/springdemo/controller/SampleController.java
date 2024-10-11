package com.pgm.springdemo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    //get으로 hello http에서 localhost:8080/hello 라고 하면 밑 함수를 수행한다.
    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "hello";
        //위 return 이 논리적인 view가 되고 이게 servlet-context의 bean으로 간다.
        // 그리고 prefix + /hello + suffix 가 된다.
        // /WEB-INF/views/hello.jsp 이렇게 된다.
    }
    @GetMapping("/ex1")
    public void ex1(@RequestParam("name") String name,
                    @RequestParam("age") int age,
                    @RequestParam("gender") String gender,
                    Model model){
        log.info("ex1");
        log.info(name);
        log.info(age);
        log.info(gender);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("gender", gender);
    }
    @GetMapping("/ex2/{name}")
    public void ex2(@PathVariable("name") String name){
        log.info("ex2");
        log.info(name);
    }
    @GetMapping("/ex3")
    public void ex3(@RequestParam("dueDate") LocalDate dueDate, Model model){
        log.info("ex3");
        log.info(dueDate);
        model.addAttribute("dueDate", dueDate);
    }
    @GetMapping("/ex4")
    public String ex4(RedirectAttributes redirectAttributes){
        log.info("ex4");
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addAttribute("name", "aaaa");
        return "redirect:/ex5";
    }
    @GetMapping("/ex5")
    public void ex5(@RequestParam("name") String name, Model model){
        log.info("ex5");
        log.info(name);
        model.addAttribute("name", name);
    }
    @GetMapping("/ex6")
    public void ex6(@RequestParam("p1") String p1,
                    @RequestParam("p2") int p2){
        log.info("ex6");
        log.info(p1);
        log.info(p2);
    }
}
