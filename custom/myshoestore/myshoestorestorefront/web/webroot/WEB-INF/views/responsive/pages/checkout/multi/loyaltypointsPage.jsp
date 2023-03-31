<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="multiCheckout"
tagdir="/WEB-INF/tags/responsive/checkout/multi"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement"
tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="address" tagdir="/WEB-INF/tags/responsive/address"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<div>

<div class="col-sm-12 col-lg-12">


<h2 style="color: green; text-align: center;">Thank you
${userName} for using your Loyalty Points</h2>

<p style="font-weight: bold;">Original Loyalty Points:</P>
<p>
<font color="#FF7F50" size="3" face="Arial, Helvetica, sans-serif">${intloyaltyPoints}</font>
</P>

<p style="font-weight: bold;">Remaining Loyalty Points:</P>
<p>
<font color="#FF7F50" size="3" face="Arial, Helvetica, sans-serif">${finalloyaltyPoints}</font>
</P>

<spring:url var="loyaltyPointsUrl"
value="{contextPath}/checkout/multi/payment-method/add"
htmlEscape="false">
<spring:param name="contextPath" value="${request.contextPath}" />
</spring:url>

<form id="loyaltyPointsForm"
action="${fn:escapeXml(loyaltyPointsUrl)}" method="get">
<button type="submit"
style="background-color: #FF8C00; font-size: 20px; color: white">
<spring:theme code="continue" />
</button>
</form>
</div>

</div>