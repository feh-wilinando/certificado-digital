package br.com.fws.prac.certificado_digital.controllers;

import br.com.fws.prac.certificado_digital.helper.Message;
import br.com.fws.prac.certificado_digital.infra.RecaptchaComponent;
import br.com.fws.prac.certificado_digital.models.clients.Certificate;
import br.com.fws.prac.certificado_digital.models.forms.CertificateRequestForm;
import br.com.fws.prac.certificado_digital.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by nando on 05/12/16.
 */
@Controller
@RequestMapping("/certificates")
public class CertificateController {

    @Autowired
    private RecaptchaComponent recaptchaComponent;

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ModelAndView list(){

        ModelAndView modelAndView = new ModelAndView("certificates/list");

        List<Certificate> certificates = certificateService.listAllByCurrentCompany();

        modelAndView.addObject("certificates", certificates);

        return modelAndView;
    }



    @GetMapping("/form/{id}")
    public ModelAndView form(@PathVariable("id") Long id , Model model, RedirectAttributes redirectAttributes){

        Optional<CertificateRequestForm> formOptional = certificateService.findById(id);


        if (formOptional.isPresent()) {

            CertificateRequestForm certificateRequestForm = formOptional.get();

            model.addAttribute("certificateRequestForm", certificateRequestForm);

            return form(certificateRequestForm);
        }

        Message message = new Message("Certificado não localizado", "Não foi possível localizar um certificado com o id " + id, Message.Severity.DANGER);

        redirectAttributes.addFlashAttribute("message", message);

        return new ModelAndView("redirect:/certificates");
    }

    @GetMapping("/form")
    public ModelAndView form(CertificateRequestForm certificateRequestForm){
        ModelAndView modelAndView = new ModelAndView("/certificates/form");

        modelAndView.addObject("recaptchaPublicKey", recaptchaComponent.getPublicKey());

        return modelAndView;
    }

    @PostMapping("/form")
    public ModelAndView save(@Valid CertificateRequestForm certificateRequestForm, BindingResult result, RedirectAttributes redirectAttributes){

        if (result.hasErrors()){
            return form(certificateRequestForm);
        }

        certificateService.persist(certificateRequestForm);

        Message message = new Message("Email enviado com sucesso.", "Coleta solicitada com sucesso", Message.Severity.INFO);

        redirectAttributes.addFlashAttribute("info", message);

        return new ModelAndView("redirect:/certificates");

    }

}
