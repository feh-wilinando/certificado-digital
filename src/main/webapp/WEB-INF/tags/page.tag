<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap-select.min.css"/>
    <link rel="stylesheet" href="/assets/css/main.css"/>
    <link href="http://www.prac.com.br/site/templates/interdevice_protostar/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
    <title>Certificado Digital</title>
</head>
<body>
    <header>
        <nav class="row">
            <sec:authorize access="isAuthenticated()" var="authenticated"/>

            <div class="col-md-12 col-xs-12">
                <div class="col-md-3 col-xs-12 ${authenticated? '':'col-md-offset-4'} ">
                    <img src="http://www.prac.com.br/site/images/logotipo1.jpg" alt="logo"/>
                </div>
                <sec:authorize access="isAuthenticated()">
                <div class="col-md-5 col-xs-12">
                    <div class="container-fluid">
                        <ul class="nav nav-pills">
                            <li><a href="/companies/my-account">Meu Cadastro</a></li>
                            <li><a href="/certificates">Certificados</a></li>
                            <li><a href="/certificates/form/">Solicitar Coleta</a></li>
                            <li><a href="/logout">Sair</a></li>
                        </ul>
                    </div>
                </div>
                </sec:authorize>
            </div>
        </nav>
    </header>
    <section class="container-fluid">
        <jsp:doBody/>
    </section>
    <footer
            style="width: 100%; margin: 80px 0px 0px 0px; background: none repeat scroll 0 0 #EBEBEB; box-shadow: 0px -6px 8px 4px rgba(00, 00, 00, 0.2);">
        <div class="container-fluid">
            <div class="col-md-2 col-xs-12">
                    <span
                            style="background: none repeat scroll 0 0 #4195A0; color: #FFFFFF; display: block; font-size: 0.7em; margin-bottom: -1em; padding: 2px 8px; width: 178px;">
                        &copy; PRAC - Programa de Responsabilidade Ambiental Compartilhada 2001 -
                        2016 </span> <br/> <span style="font-size: 0.8em">Todos os Direitos Reservados.</span>
            </div>
        </div>
    </footer>
    <script type="text/javascript" src="/assets/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/assets/js/jquery.mask.min.js"></script>
    <script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/assets/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="/assets/js/bootstrap-checkbox.min.js"></script>
    <script src='https://www.google.com/recaptcha/api.js'></script>
    <script src='/assets/js/application.js'></script>
</body>
</html>
