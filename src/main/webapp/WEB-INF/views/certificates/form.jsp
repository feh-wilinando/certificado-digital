<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page>
    <jsp:body>
        <div class="col-md-4 col-xs-12 col-md-offset-4">
            <form:form commandName="certificateRequestForm" class="form-horizontal" servletRelativeAction="/certificates/form"
                       method="post">

                <form:hidden path="id"/>

                <fieldset>
                    <legend>Sistema Prac Certificados</legend>


                    <div class="row">
                            <div class="form-group">
                                <div class="col-md-4">
                                    <label for="invoice">Nota Fiscal</label>
                                </div>
                                <div class="col-md-8">
                                    <form:input id="invoice" path="invoice" cssClass="form-control"
                                                placeholder="123"/>
                                    <form:errors cssClass="text-danger" path="invoice"/>
                                </div>
                            </div>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-4">
                                <label for="quantity">Quantidade</label>
                            </div>
                            <div class="col-md-8">
                                <form:input id="quantity" path="quantity" cssClass="form-control"
                                            placeholder="2"/>
                                <form:errors cssClass="text-danger" path="quantity"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-4">
                                <label for="weigth">Peso</label>
                            </div>
                            <div class="col-md-8">
                                <form:input id="weigth" path="weigth" cssClass="form-control"
                                            placeholder="10,5"/>
                                <form:errors cssClass="text-danger" path="weigth"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-4">
                                <label for="collectionLocation">Local de Coleta</label>
                            </div>
                            <div class="col-md-8">
                                <form:input id="collectionLocation" path="collectionLocation" cssClass="form-control"
                                            placeholder="São Paulo"/>
                                <form:errors cssClass="text-danger" path="collectionLocation"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-offset-3">
                            <div id="recaptcha" class="g-recaptcha" data-sitekey="${recaptchaPublicKey}"></div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-4 col-md-offset-4 col-xs-12">
                            <button type="submit" class="btn btn-primary btn-block">Solicitar</button>
                        </div>
                    </div>

                </fieldset>

            </form:form>
        </div>
    </jsp:body>
</template:page>