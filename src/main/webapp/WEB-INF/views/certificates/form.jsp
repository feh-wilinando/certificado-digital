<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page>
    <jsp:body>
        <style>
            .bootstrap-select>.dropdown-toggle{width: 60%}
        </style>
        <div class="col-md-6 col-xs-12 col-md-offset-3">
            <form:form commandName="certificateRequestForm" class="form-horizontal"
                       servletRelativeAction="/certificates/form"
                       method="post">

                <form:hidden path="id"/>

                <fieldset>
                    <legend>Solicitação de coleta</legend>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-2">
                                <label for="startingTime">Horário</label>
                            </div>
                            <div class="col-md-2">
                                <form:input id="startingTime" path="startingTime" cssClass="form-control horario-mask"
                                            placeholder="08:00"/>
                                <form:errors cssClass="text-danger" path="startingTime"/>
                            </div>
                            <div class="col-md-1">
                                <label for="endingTime">até</label>
                            </div>
                            <div class="col-md-2">
                                <form:input id="endingTime" path="endingTime" cssClass="form-control horario-mask"
                                            placeholder="20:00"/>
                                <form:errors cssClass="text-danger" path="endingTime"/>
                            </div>

                            <div class="col-md-2">
                                <label for="invoice">Nota Fiscal</label>
                            </div>
                            <div class="col-md-3">
                                <form:input id="invoice" path="invoice" cssClass="form-control"
                                            placeholder="0123456789"/>
                                <form:errors cssClass="text-danger" path="invoice"/>
                            </div>

                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-2">
                                <label for="volume">Volume</label>
                            </div>
                            <div class="col-md-2">
                                <form:input id="volume" path="volume" cssClass="form-control"
                                            placeholder="10"/>
                                <form:errors cssClass="text-danger" path="volume"/>
                            </div>

                            <div class="col-md-1">
                                <label for="weigth">Peso</label>
                            </div>

                            <div class="col-md-2">
                                <form:input id="weigth" path="weigth" cssClass="form-control"
                                            placeholder="10,5"/>
                                <form:errors cssClass="text-danger" path="weigth"/>
                            </div>

                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-6">
                                <label for="palletizedAndStretched">A carga está paletizada e strechada? </label>
                            </div>
                            <div class="col-md-3">
                                <form:checkbox path="palletizedAndStretched" id="palletizedAndStretched"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-6">
                                <label for="useRegisteredData">Local da coleta é o mesmo do cadastro? </label>
                            </div>
                            <div class="col-md-3">
                                <form:checkbox path="useRegisteredData" id="useRegisteredData" checked="checked"/>
                            </div>
                        </div>
                    </div>

                    <div id="additional-data" hidden>

                        <fieldset>
                            <legend>Dados adicionais</legend>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-3">
                                        <label for="companyName">Razão Social</label>
                                    </div>

                                    <div class="col-md-9">
                                        <form:input id="companyName" path="companyName" cssClass="form-control"
                                                    placeholder="Nome da Empresa LTDA."/>
                                        <form:errors cssClass="text-danger" path="companyName"/>
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-3">
                                        <label for="zipCode">CEP</label>
                                    </div>

                                    <div class="col-md-4">
                                        <form:input id="zipCode" path="address.zipCode"
                                                    cssClass="form-control cep-mask" placeholder="99999-999"/>
                                        <form:errors cssClass="text-danger" path="address.zipCode"/>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-3">
                                        <label for="street">Endereço</label>
                                    </div>

                                    <div class="col-md-6">
                                        <form:input id="street" path="address.street" cssClass="form-control"
                                                    placeholder="Rua Alcantara Machado"/>
                                        <form:errors cssClass="text-danger" path="address.street"/>
                                    </div>

                                    <div class="col-md-1">
                                        <label for="number">Nº</label>
                                    </div>
                                    <div class="col-md-2">
                                        <form:input id="number" path="address.number" cssClass="form-control"
                                                    placeholder="4526"/>
                                        <form:errors cssClass="text-danger" path="address.number"/>
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-3">
                                        <label for="complement">Complemento</label>
                                    </div>

                                    <div class="col-md-4">
                                        <form:input id="complement" path="address.complement" cssClass="form-control"
                                                    placeholder="8º andar"/>
                                        <form:errors cssClass="text-danger" path="address.complement"/>
                                    </div>

                                    <div class="col-md-2">
                                        <label for="neighborhood">Bairro</label>
                                    </div>

                                    <div class="col-md-3">
                                        <form:input id="neighborhood" path="address.neighborhood"
                                                    cssClass="form-control" placeholder="Tatuapé"/>
                                        <form:errors cssClass="text-danger" path="address.neighborhood"/>
                                    </div>

                                </div>
                            </div>


                            <div class="row">
                                <div class="form-group">

                                    <div class="col-md-3">
                                        <label for="city">Cidade</label>
                                    </div>

                                    <div class="col-md-4">
                                        <form:input id="city" path="address.city" cssClass="form-control"
                                                    placeholder="São Paulo"/>
                                        <form:errors cssClass="text-danger" path="address.city"/>
                                    </div>

                                    <div class="col-md-2">
                                        <label for="state">Estado</label>
                                    </div>
                                    <div class="col-md-2">
                                        <form:select id="state" path="address.state" cssClass="selectpicker"
                                                     data-size="3"
                                                     data-live-search="true" title="Selecione um estado">
                                            <form:options/>
                                        </form:select>
                                        <form:errors cssClass="text-danger" path="address.state"/>
                                    </div>

                                </div>
                            </div>
                        </fieldset>
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
