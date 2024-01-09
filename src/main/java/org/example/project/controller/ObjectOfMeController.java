package org.example.project.controller;

import org.example.project.service.impl.ObjectOfMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ObjectOfMeController {
    @Autowired
    ObjectOfMeService objectOfMeService;

}
