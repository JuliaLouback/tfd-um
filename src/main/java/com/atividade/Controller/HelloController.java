package com.atividade.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    @GetMapping("/")
    public String index(Model model){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        model.addAttribute("nome", "Julia Louback Ribeiro");
        model.addAttribute("data", LocalDateTime.now().format(formatter).toString());
        return "index";
    }
    
}
