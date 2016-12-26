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
            <td><strong>Quantidade</strong></td>
            <td>${certificate.quantity}</td>
            <td><strong>Peso</strong></td>
            <td>${certificate.weigth?string[",##0.00"]}</td>
        </tr>

        <tr>
            <td><strong>Local de Retirada</strong></td>
            <td>${certificate.collectionLocation}</td>
        </tr>

        <tr>
            <td><strong>Empresa:</strong></td>
            <td colspan="6">${certificate.company.companyName}</td>
        </tr>
        <tr>
            <td><strong>CNPJ:</strong></td>
            <td colspan="6">${certificate.company.companyRegistration}</td>
        </tr>

        <tr>
            <td><strong>Nome:</strong></td>
            <td>${certificate.company.contact.name}</td>
            <td><strong>Cargo:</strong></td>
            <td>${certificate.company.contact.jobTitle}</td>
        </tr>

        <tr>
            <td><strong>E-mail:</strong></td>
            <td>${certificate.company.contact.email}</td>
        </tr>

        <tr>
            <td><strong>Telefone:</strong></td>
            <td>${certificate.company.phoneNumber}</td>
        </tr>
        <tr>
            <td><strong>Celular:</strong></td>
            <td>${certificate.company.cellNumber}</td>
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
