<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/desktop/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>
<%@ taglib prefix="breadcrumb" tagdir="/WEB-INF/tags/desktop/nav/breadcrumb" %>
<link href="/_ui/responsive/common/css/landingLayout2Page.css" rel="stylesheet" type="text/css" />
<div class="customOffersComponent">
<p class="customOffersComponent_header_text">${headerText}</p>
<img alt="Offer Image" src="${offerImage.url}" class="offers_image">
<ul class="offers_list">
<c:forEach items="${offerImageLinks}" var="offerImageLink">
<li class="offers_list_element"><a href="${offerImageLink.url}">${offerImageLink.name}</a></li>
</c:forEach>
</ul>
<p class="customOffersComponent_header_text">${footerText}</p>
</div>