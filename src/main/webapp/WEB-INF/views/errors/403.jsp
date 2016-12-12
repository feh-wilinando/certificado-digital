<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page>
    <jsp:body>
        <div class="col-md-3 col-xs-12 col-md-offset-4">
            <fieldset>
                <legend>Sistema Prac Certificados</legend>
                <h3>Acesso não permitido</h3>

                <h5>Você será redirecionado para a tela de Login automaticamente</h5>
            </fieldset>
        </div>

        <script>
            setTimeout(function(){
                window.location="/";
            },5000);
        </script>
    </jsp:body>
</template:page>