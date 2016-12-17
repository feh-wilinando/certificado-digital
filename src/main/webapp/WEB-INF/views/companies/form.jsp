<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:page>
    <jsp:body>
        <form:form commandName="companyForm" class="form-horizontal" servletRelativeAction="/companies/form" method="post">

            <form:hidden path="id"/>

            <div class="col-md-7 col-xs-12 col-md-offset-3">

                <c:if test="${message != null}">
                    <template:alert message="${message}"/>
                </c:if>

                <fieldset>
                    <legend>Cadastro de Empresa</legend>

                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-2">
                                <label for="razaoSocial">Razão social</label>
                            </div>
                            <div class="col-md-10">
                                <form:input id="razaoSocial" path="companyName" cssClass="form-control"
                                            placeholder="Minha empresa LTDA."/>
                                <form:errors cssClass="text-danger" path="companyName"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label for="cnpj"> CNPJ</label>
                            </div>
                            <div class="col-sm-4">
                                <form:input id="cnpj" path="companyRegistration"
                                            cssClass="form-control cnpj-mask" placeholder="99.999.999/9999-99"/>
                                <form:errors cssClass="text-danger" path="companyRegistration"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">

                        <div class="form-group">

                            <div class="col-sm-2">
                                <label for="ie">Inscrição Estadual</label>
                            </div>

                            <div class="col-sm-4">
                                <form:input id="ie" path="stateRegistration" cssClass="form-control"/>
                                <form:errors cssClass="text-danger" path="stateRegistration"/>
                            </div>

                            <div class="col-sm-2">
                                <label for="zipCode">CEP</label>
                            </div>

                            <div class="col-sm-4">
                                <form:input id="zipCode" path="address.zipCode"
                                            cssClass="form-control cep-mask" placeholder="99999-999"/>
                                <form:errors cssClass="text-danger" path="address.zipCode"/>
                            </div>

                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label for="street">Endereço</label>
                            </div>

                            <div class="col-sm-7">
                                <form:input id="street" path="address.street" cssClass="form-control"
                                            placeholder="Rua Alcantara Machado"/>
                                <form:errors cssClass="text-danger" path="address.street"/>
                            </div>

                            <div class="col-sm-1">
                                <label for="number">Nº</label>
                            </div>
                            <div class="col-sm-2">
                                <form:input id="number" path="address.number" cssClass="form-control"
                                            placeholder="4526"/>
                                <form:errors cssClass="text-danger" path="address.number"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label for="complement">Complemento</label>
                            </div>

                            <div class="col-sm-4">
                                <form:input id="complement" path="address.complement" cssClass="form-control"
                                            placeholder="8º andar"/>
                                <form:errors cssClass="text-danger" path="address.complement"/>
                            </div>

                            <div class="col-sm-2">
                                <label for="neighborhood">Bairro</label>
                            </div>

                            <div class="col-sm-4">
                                <form:input id="neighborhood" path="address.neighborhood"
                                            cssClass="form-control" placeholder="Tatuapé"/>
                                <form:errors cssClass="text-danger" path="address.neighborhood"/>
                            </div>

                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">

                            <div class="col-sm-2">
                                <label for="city">Cidade</label>
                            </div>

                            <div class="col-sm-4">
                                <form:input id="city" path="address.city" cssClass="form-control"
                                            placeholder="São Paulo"/>
                                <form:errors cssClass="text-danger" path="address.city"/>
                            </div>

                            <div class="col-sm-2">
                                <label for="state">Estado</label>
                            </div>
                            <div class="col-sm-4">
                                <form:select id="state" path="address.state" cssClass="selectpicker" data-size="3" data-live-search="true" title="Selecione um estado">
                                   <form:options/>
                                </form:select>
                                <form:errors cssClass="text-danger" path="address.state"/>
                            </div>

                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label for="contact">Contato</label>
                            </div>
                            <div class="col-sm-10">
                                <form:input id="contact" path="contact.name" cssClass="form-control"
                                            placeholder="João da Silva"/>
                                <form:errors cssClass="text-danger" path="contact.name"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">

                            <div class="col-sm-2">
                                <label for="email">E-mail</label>
                            </div>

                            <div class="col-sm-4">
                                <form:input id="email" path="contact.email" cssClass="form-control" type="email"
                                            placeholder="joao.silva@email.com"/>
                                <form:errors cssClass="text-danger" path="contact.email"/>
                            </div>

                            <div class="col-sm-2">
                                <label for="jobTitle">Cargo</label>
                            </div>

                            <div class="col-sm-4">
                                <form:input id="jobTitle" path="contact.jobTitle" cssClass="form-control"
                                            placeholder="Gerente, Auxiliar, Analista..."/>
                                <form:errors cssClass="text-danger" path="contact.jobTitle"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <label for="phoneNumber">Telefone</label>
                            </div>
                            <div class="col-sm-4">
                                <form:input id="phoneNumber" path="phoneNumber"
                                            cssClass="form-control telefone-mask" placeholder="(99) 9999-9999 ou 0800 9999-9999"/>
                                <form:errors cssClass="text-danger" path="phoneNumber"/>
                            </div>
                            <div class="col-sm-2">
                                <label for="cellNumber">Celular</label>
                            </div>
                            <div class="col-sm-4">
                                <form:input id="cellNumber" path="cellNumber"
                                            cssClass="form-control celular-mask" placeholder="(99) 9 9999-9999"/>
                                <form:errors cssClass="text-danger" path="cellNumber"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-offset-3">
                            <div id="recaptcha" class="g-recaptcha" data-sitekey="${recaptchaPublicKey}"></div>
                            <form:errors cssClass="text-danger" path=""/>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-4 col-md-offset-4 col-xs-12">
                            <button type="submit" class="btn btn-primary btn-block">Enviar para análise</button>
                        </div>
                    </div>

                </fieldset>
            </div>
        </form:form>


    </jsp:body>
</template:page>