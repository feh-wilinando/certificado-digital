<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<template:page>
    <jsp:body>

            <div class="col-md-8 col-xs-12 col-md-offset-2">

                <c:if test="${info != null}">
                    <template:alert message="${info}"/>
                </c:if>

                <c:if test="${message != null}">
                    <template:alert message="${message}"/>
                </c:if>

                <table class="table table-responsive table-hover">
                    <thead>
                        <th>Nota Fiscal</th>
                        <th>Quantidade</th>
                        <th>Peso</th>
                        <th>Local de Retirada</th>
                        <th>Data Solicitação</th>
                        <th>Data Emissão</th>
                        <th></th>
                        <th></th>
                    </thead>
                    <tbody>


                        <c:forEach items="${certificates}" var="c">

                            <tr>
                                <td>${c.invoice}</td>
                                <td>${c.quantity}</td>
                                <td><fmt:formatNumber value="${c.weigth}" pattern="##0.00"/> </td>
                                <td>${c.collectionLocation}</td>
                                <td>
                                    <template:localDate date="${c.requestDate}"/>
                                </td>
                                <td>
                                    <template:localDate date="${c.emissionDate}"/>
                                </td>
                                <td>
                                    <a href="/certificates/form/${c.id}" class="btn btn-primary">
                                            <span class="glyphicon glyphicon-pencil"/>
                                    </a>
                                </td>
                                <td>
                                    <c:if test="${c.emissionDate != null}">
                                        <a href="" class="btn btn-primary">
                                            <span class="glyphicon glyphicon-download-alt"/>
                                        </a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>

    </jsp:body>
</template:page>