<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="format" tagdir="/WEB-INF/tags/shared/format"%>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="component" tagdir="/WEB-INF/tags/shared/component"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<body>
<h2> Products to compare</h2>
<c:if test = "${not empty productList}">
		<c:forEach var = "product" items = "${productList}">
			<c:if test ="${not(product.code eq compProd.code)}">
				<c:url value="/compare/product/details?ID=${product.code}" var="productCompUrl"/>
				<div>
				<a href="${productCompUrl}">
				<div>${fn:escapeXml(product.name)}</div>
				</a>
				</div>
				<br></br>
			</c:if>
		</c:forEach>
</c:if>
</body>
</html>