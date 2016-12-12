package br.com.fws.prac.certificado_digital.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nando on 10/12/16.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(){
        return "redirect:/certificates";
    }

}
