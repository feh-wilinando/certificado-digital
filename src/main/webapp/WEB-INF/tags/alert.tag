<%@attribute name="message" required="true" type="br.com.fws.prac.certificado_digital.helper.Message"%>



<div class="alert alert-${message.severity.name().toLowerCase()} alert-dismissible" role="alert">

    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>

    <strong>${message.summary}</strong>
        ${message.detail}
</div>
