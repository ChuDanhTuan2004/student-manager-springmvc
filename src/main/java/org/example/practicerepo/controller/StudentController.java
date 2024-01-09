package org.example.practicerepo.controller;

import org.example.practicerepo.model.Student;
import org.example.practicerepo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping("/home")
    public String home(){
        return "/index";
    }

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("student", studentService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        studentService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        return modelAndView;
    }

    @GetMapping("/search/{nameSearch}")
    public ModelAndView search(@RequestParam(value = "nameSearch", required = false) String nameSearch){
        ModelAndView modelAndView = new ModelAndView("/result");
        modelAndView.addObject("searchList", studentService.findByName(nameSearch));
        return modelAndView;
    }
}
