package br.com.fws.prac.certificado_digital.controllers;

import br.com.fws.prac.certificado_digital.helper.Message;
import br.com.fws.prac.certificado_digital.models.forms.CompanyLoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by nando on 02/12/16.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public ModelAndView login(RedirectAttributes redirectAttributes){


        if ( request.getParameter("error") != null ){
            Message message = new Message("Cliente não encontrado", "Favor efetuar o cadastro!", Message.Severity.DANGER);

            redirectAttributes.addFlashAttribute("message", message);

            return new ModelAndView("redirect:/companies/form");
        }

        return new ModelAndView("login");
    }

}
