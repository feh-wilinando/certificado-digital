package br.com.fws.prac.certificado_digital.controllers;

import br.com.fws.prac.certificado_digital.helper.Message;
import br.com.fws.prac.certificado_digital.infra.RecaptchaComponent;
import br.com.fws.prac.certificado_digital.models.commons.State;
import br.com.fws.prac.certificado_digital.models.forms.CompanyForm;
import br.com.fws.prac.certificado_digital.services.CompanyService;
import br.com.fws.prac.certificado_digital.validators.DuplicatedCompanyRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by nando on 02/12/16.
 */
@Controller
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RecaptchaComponent recaptchaComponent;

    @Autowired
    private DuplicatedCompanyRegistrationValidator duplicatedCompanyRegistrationValidator;

    @InitBinder
    public void initCompanyForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(duplicatedCompanyRegistrationValidator);
    }


    @PostMapping("/form")
    public ModelAndView save(@Valid CompanyForm companyForm, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return form(companyForm);
        }

        Message message = new Message("Email enviado com sucesso.", "Cliente enviado para analise.", Message.Severity.INFO);


        redirectAttributes.addFlashAttribute("info", message);


        companyService.persist(companyForm);

        if (companyService.isLogged()) {
            return new ModelAndView("redirect:/certificates");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @GetMapping("/form")
    public ModelAndView form(CompanyForm companyForm) {
        ModelAndView modelAndView = new ModelAndView("companies/form");

        modelAndView.addObject("states", State.values());
        modelAndView.addObject("recaptchaPublicKey", recaptchaComponent.getPublicKey());

        return modelAndView;
    }

    @GetMapping("/my-account")
    public ModelAndView myCompany(Model model){

        Optional<CompanyForm> formOptional = companyService.getCurrentCompanyForm();

        if (formOptional.isPresent()) {
            CompanyForm companyForm = formOptional.get();

            model.addAttribute("companyForm", companyForm);

            return form(companyForm);
        }

        return new ModelAndView("redirect:/certificates");

    }

    @GetMapping("/activation/{hash}")
    @Transactional
    public ModelAndView activate(@PathVariable("hash") String hash){

        Optional<CompanyForm> companyForm = companyService.activeByHash(hash);


        if (companyForm.isPresent()){
            return activationSuccess(companyForm.get());
        }

        ModelAndView modelAndView = new ModelAndView("companies/no-hash-avaliable");
        modelAndView.addObject("hash", hash);

        return modelAndView;
    }


    @GetMapping("/activation")
    public ModelAndView activationSuccess(CompanyForm company){
        return new ModelAndView("companies/activation-success");
    }

}
