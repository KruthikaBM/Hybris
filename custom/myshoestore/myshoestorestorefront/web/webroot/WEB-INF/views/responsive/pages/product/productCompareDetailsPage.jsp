<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<body>
<h2>Products Comparison Details</h2>

<div>
<p>${initialproduct.code}</p>
<p>${initialproduct.name}</p>
<p>${initialproduct.manufacturerName}</p>

<c:if test="${not empty initialproduct.comments }">

	<p>${initialproduct.comments}</p>

</c:if>

<c:if test="${not empty initialproduct.averageRating}">

<p>${initialproduct.averageRating}</p>

</c:if>

</div>

<div style="color:#FF7F50">
<p>${compProd.code}</p>
<p>${compProd.name}</p>
<p>${compProd.manufacturerName}</p>

<c:if test="${not empty compProd.comments}">

<p>${compProd.comments}</p>

</c:if>

<c:if test="${not empty compProd.averageRating}">
	<p>${compProd.averageRating}</p>
</c:if>

</div>

</body>
</html>