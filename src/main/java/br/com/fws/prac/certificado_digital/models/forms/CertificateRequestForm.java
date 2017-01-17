package br.com.fws.prac.certificado_digital.models.forms;

import br.com.fws.prac.certificado_digital.models.clients.Certificate;
import br.com.fws.prac.certificado_digital.models.clients.Company;
import br.com.fws.prac.certificado_digital.models.commons.Address;
import br.com.fws.prac.certificado_digital.models.commons.Contact;
import br.com.fws.prac.certificado_digital.repositories.CompanyRepository;
import br.com.fws.prac.certificado_digital.validators.UseRecaptcha;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;

import javax.annotation.PostConstruct;
import javax.persistence.Embedded;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Optional;

/**
 * Created by nando on 10/12/16.
 */
@Data
@NoArgsConstructor
@UseRecaptcha
public class CertificateRequestForm implements Form<Certificate>{

    private Long id;

    private String invoice;

    @NotNull
    @Min(1)
    private Integer volume;

    @NotNull
    @Min(1)
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "##0.00")
    private BigDecimal weigth;

    @NotNull
    private LocalTime startingTime;

    @NotNull
    private LocalTime endingTime;

    @NotNull
    private Boolean palletizedAndStretched;

    @NotBlank
    private String companyName;

    @Valid
    private Address address = new Address();

    @NotNull
    private Boolean useRegisteredData;

    @Valid
    private Contact contact = new Contact();

    @Override
    public void from(Certificate entity) {
        this.id = entity.getId();
        this.invoice = entity.getInvoice();
        this.volume = entity.getVolume();
        this.weigth = entity.getWeigth();
        this.startingTime = entity.getStartingTime();
        this.endingTime = entity.getEndingTime();
        this.palletizedAndStretched = entity.isPalletizedAndStretched();
        this.companyName = entity.getCompanyName();
        this.address = entity.getAddress();
        this.contact = entity.getContact();
    }

    @Override
    public void to(Certificate entity) {
        entity.setId(id);
        entity.setInvoice(invoice);
        entity.setVolume(volume);
        entity.setWeigth(weigth);
        entity.setStartingTime(startingTime);
        entity.setEndingTime(endingTime);
        entity.setPalletizedAndStretched(palletizedAndStretched);
        entity.setCompanyName(companyName);
        entity.setAddress(address);
        entity.setContact(contact);

    }

    public void inflate(Optional<CertificateRequestForm> formOptional){
        if (formOptional.isPresent()){

            CertificateRequestForm form = formOptional.get();

            this.id = form.getId();
            this.invoice = form.getInvoice();
            this.volume = form.getVolume();
            this.weigth = form.getWeigth();
            this.startingTime = form.getStartingTime();
            this.endingTime = form.getEndingTime();
            this.palletizedAndStretched = form.getPalletizedAndStretched();
            this.companyName = form.getCompanyName();
            this.address = form.getAddress();
            this.contact = form.getContact();

        }
    }

}
