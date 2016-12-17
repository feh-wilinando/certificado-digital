<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page>
    <jsp:body>

        <form:form class="form-horizontal" commandName="companyLoginForm" servletRelativeAction="/login" >

            <div class="col-md-3 col-xs-12 col-md-offset-4">

                <c:if test="${info != null}">
                    <template:alert message="${info}"/>
                </c:if>
                
                <fieldset>
                    <legend>Solicitação de Coleta</legend>

                    <div class="row">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="cnpj">CNPJ</label>
                            <div class="col-sm-10">
                                <input name="companyRegistration" class="form-control cnpj-mask" id="cnpj"/>
                            </div>

                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-md-7 col-md-offset-5">
                            <button class="btn btn-primary btn-block" id="enter" type="submit">Entrar</button>
                        </div>



                        <div class="col-md-7 col-md-offset-5">
                            <a href="/companies/form"> ou cadastrar empresa </a>
                        </div>

                    </div>

                </fieldset>
            </div>
        </form:form>
    </jsp:body>
</template:page>
