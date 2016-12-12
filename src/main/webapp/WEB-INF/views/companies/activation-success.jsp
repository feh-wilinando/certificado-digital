<%@taglib prefix="template" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<template:page>
    <jsp:body>


        <div class="col-md-3 col-xs-12 col-md-offset-4">

            <fieldset>
                <legend>Liberação</legend>
                <h3>Cliente liberado com sucesso</h3>
            </fieldset>

        </div>

        <script>
            setTimeout(function(){
                window.location="/";
            },5000);
        </script>
    </jsp:body>
</template:page>
