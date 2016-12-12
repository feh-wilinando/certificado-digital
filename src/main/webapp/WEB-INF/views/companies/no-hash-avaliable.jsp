<%@taglib prefix="template" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<template:page>
    <jsp:body>


        <div class="col-md-3 col-xs-12 col-md-offset-4">

            <h3>Não existe nenhum clente pendente de ativação para esse hash</h3>

            <h5 class="text-info">${hash}</h5>

        </div>

    </jsp:body>
</template:page>
