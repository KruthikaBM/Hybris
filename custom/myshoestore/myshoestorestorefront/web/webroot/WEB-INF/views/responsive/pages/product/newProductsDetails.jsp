
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.lang.*" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>

<template:page pageTitle="${pageTitle}">
<div class="row">
        <div class="col-sm-6 col-sm-push-6">
            <div class="accountActions">
                <form:form action="update_description" method="get">
            	    <button type="submit" class="btn btn-primary btn-block">
                        <spring:theme code="Update Description" text="Update Description"/>
                    </button>
                </form:form>
            </div>
        </div>
        <div class="col-sm-6 col-sm-pull-6">
            <div class="accountActions">
                <form:form action="create_products" method="get">
            	    <button type="submit" class="btn btn-primary btn-block">
                        <spring:theme code="Create product" text="Create product"/>
                    </button>
                </form:form>
            </div>
        </div>
    </div>

<br>
<c:if test="${not empty  newProducts}">
<table>
   <tr>
    <th><spring:theme code="myshoestore.newProducts.code"/></th>
    <th><spring:theme code="myshoestore.newProducts.name"/></th>
   <th><spring:theme code="myshoestore.newProducts.description"/></th>
   <th><spring:theme code="myshoestore.newProducts.size"/></th>
   <th><spring:theme code="myshoestore.newProducts.color"/></th>
   <th><spring:theme code="myshoestore.newProducts.purchaseDate"/></th>
   <th><spring:theme code="myshoestore.newProducts.warranty"/></th>
           </tr>
<c:forEach items="${newProducts}" var="newProducts">
<tr>
<td>${newProducts.code}</td>
<td>${newProducts.name}</td>
<td>${newProducts.description}</td>
<td>${newProducts.size}</td>
<td>${newProducts.color}</td>
<td>${newProducts.purchaseDate}</td>
<td>${newProducts.warranty}</td>
<td>
		   <form:form action="delete_product/${newProducts.code}" method="post">
		        <button type="submit" class="btn btn-danger btn-block">
                    <spring:theme code="Delete" text="Delete"/>
                </button>
            </form:form>
</td>
</tr>
</c:forEach>
</table>
</c:if>
</template:page>