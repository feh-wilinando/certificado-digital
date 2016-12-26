package br.com.fws.prac.certificado_digital.models.forms;

import br.com.fws.prac.certificado_digital.models.clients.Certificate;
import br.com.fws.prac.certificado_digital.validators.UseRecaptcha;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
    private Integer quantity;

    @NotBlank
    private String collectionLocation;

    @NotNull
    @Min(1)
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "##0.00")
    private BigDecimal weigth;


    @Override
    public void from(Certificate entity) {
        this.id = entity.getId();
        this.invoice = entity.getInvoice();
        this.quantity = entity.getQuantity();
        this.collectionLocation = entity.getCollectionLocation();
        this.weigth = entity.getWeigth();
    }

    @Override
    public void to(Certificate entity) {
        entity.setId(id);
        entity.setInvoice(invoice);
        entity.setQuantity(quantity);
        entity.setCollectionLocation(collectionLocation);
        entity.setWeigth(weigth);
    }
}
