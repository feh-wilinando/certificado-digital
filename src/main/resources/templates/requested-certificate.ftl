<!DOCTYPE html>
<html style="margin: 0 auto; padding: 0 auto;">
<head>
    <title>Cadastro de Empresa - PRAC</title>
</head>

<body style="margin: 0 auto; padding: 0 auto; font-family: Arial">
<header style="width: 100%; margin: auto">
    <div style="width: 50%; margin: auto">
        <img src="http://www.prac.com.br/site/images/logotipo1.jpg"
             alt="logo">
    </div>
</header>
<section style="width: 80%; margin: auto; background: #EBEBEB">

    <table>

        <tr>
            <td><strong>Nota</strong></td>
            <td>${certificate.invoice}</td>
            <td><strong>Data de solicitação</strong></td>
            <td>${certificate.requestDate}</td
        </tr>

        <tr>
            <td><strong>Horário de Retirada</strong></td>
            <td>${certificate.startingTime}</td>
            <td><strong>às</strong></td>
            <td>${certificate.endingTime}</td>
        </tr>

        <tr>
            <td><strong>Volume</strong></td>
            <td>${certificate.volume}</td>
            <td><strong>Peso</strong></td>
            <td>${certificate.weigth?string[",##0.00"]}</td>
        </tr>

        <tr>
            <td><strong>Carga paletizada e strechada</strong></td>
            <td>${certificate.palletizedAndStretched?then("Sim", "Não")}</td>
        </tr>

        <tr>
            <td><strong>Solicitante</strong></td>
            <td colspan="6">${certificate.requester.companyName}</td>
        </tr>
        <tr>
            <td><strong>CNPJ</strong></td>
            <td colspan="6">${certificate.requester.companyRegistration}</td>
        </tr>

        <tr>
            <td><strong>Contato</strong></td>
            <td>${certificate.requester.contact.name}</td>
            <td><strong>Cargo</strong></td>
            <td>${certificate.requester.contact.jobTitle}</td>
        </tr>

        <tr>
            <td><strong>E-mail</strong></td>
            <td>${certificate.requester.contact.email}</td>
        </tr>

        <tr>
            <td><strong>Telefone</strong></td>
            <td>${certificate.requester.phoneNumber}</td>
        </tr>
        <tr>
            <td><strong>Celular</strong></td>
            <td>${certificate.requester.cellNumber}</td>
        </tr>

        <tr>
            <h3>Local de Retirada</h3>
        </tr>
        <tr>
            <td><strong>Empresa</strong></td>
            <td>${certificate.companyName}</td>
        </tr>

        <tr>
            <td><strong>Enredeço</strong></td>
            <td>${certificate.address.street}</td>
            <td><strong>Nº</strong></td>
            <td>${certificate.address.number}</td>
        </tr>

        <tr>
            <td><strong>Complemento</strong></td>
            <td>${certificate.address.complement}</td>
            <td><strong>Bairro</strong></td>
            <td>${certificate.address.neighborhood}</td>
        </tr>

        <tr>
            <td><strong>Cidade</strong></td>
            <td>${certificate.address.city}</td>
            <td><strong>Estado</strong></td>
            <td>${certificate.address.state}</td>
        </tr>

        <tr>
            <td><strong>CEP</strong></td>
            <td>${certificate.address.zipCode}</td>
        </tr>


    </table>

</section>

<footer
        style="width: 100%; margin: 80px 0px 0px 0px; background: none repeat scroll 0 0 #EBEBEB; box-shadow: 0px -6px 8px 4px rgba(00, 00, 00, 0.2);">
    <div style="width: 50%; margin: auto;">
			<span
                    style="background: none repeat scroll 0 0 #4195A0; color: #FFFFFF; display: block; font-size: 9px; margin-bottom: -8px; padding: 2px 8px; width: 178px; text-align: center">©
				PRAC - Programa de Responsabilidade Ambiental Compartilhada 2001 -
				2016 </span> <br /> <span style="font-size: 10px">Todos os Direitos Reservados.</span>
    </div>
</footer>

</body>
</html>
