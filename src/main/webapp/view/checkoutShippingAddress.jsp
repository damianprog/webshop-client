<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/checkoutShippingAddress.css"
	type="text/css" />
<link rel="stylesheet" href="/css/css/fontello.css" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text|Noto+Serif:400i&amp;subset=latin-ext"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Cabin"
	rel="stylesheet">
<script src="/css/js/jquery-3.3.1.min.js"></script>



</head>

<body>

	<div id="container">

		<jsp:include page="/view/header.jsp" />

		<div id="leftSide">

			<div class="unactiveLabel">
				<img style="vertical-align: middle"
					src="/css/img/number-one-in-a-circle-grey.png"> Shipping
				Options
			</div>

			<div id="edit">
				<a href="/logged/showCheckoutShippingType"> Edit </a>
			</div>

			<div style="clear: both"></div>

			<hr>


			<div id="headerInfo">
				<img style="vertical-align: middle"
					src="/css/img/number-two-in-a-circle.png"> Enter shipping
				address
			</div>

			<div id="defaultAddressDiv">
				<input id="defaultAddressCheckbox" type="checkbox"
					name="defaultAddress"> Use my default Address
			</div>

			<form:form id="addressForm" action="/logged/addCustomAddressToOrder"
				modelAttribute="userCustomAddress" method="POST">

				<table id="shippingAddressesTable">
					<form:hidden path="id" />
					<tr>
						<td>First Name*<br /> <form:input path="firstName"
								placeholder="First Name" class="inputBoxShippingAddresses"
								required="required" />
						</td>

						<td class="rightTd">Street Address*<br /> <form:input
								path="street" placeholder="Street Address"
								class="inputBoxShippingAddresses" required="required" />
						</td>
					</tr>

					<tr>
						<td>Last Name*<br /> <form:input path="lastName"
								placeholder="Last Name" class="inputBoxShippingAddresses"
								required="required" />
						</td>

						<td class="rightTd">City*<br /> <form:input path="city"
								placeholder="City" class="inputBoxShippingAddresses"
								required="required" />
						</td>
					</tr>

					<tr>
						<td>Phone*<br /> <form:input path="phone"
								placeholder="Phone" class="inputBoxShippingAddresses"
								required="required" />
						</td>
						<td class="rightTd">Country*<br /> <form:input
								path="country" placeholder="Country"
								class="inputBoxShippingAddresses" required="required" />
						</td>
					</tr>

					<tr>
						<td>Post-Code*<br /> <form:input path="postCode"
								placeholder="Post-Code" class="inputBoxShippingAddresses"
								required="required" />
						</td>
					</tr>
				</table>

				<input id="continueSubmit" type="submit" value="Continue" />
			</form:form>
		</div>

		<div id="rightSide">


			<div id="receipt">
				<table id="priceInfoTable">

					<tr>
						<td>SUBTOTAL (${overallQuantity} Items)</td>

						<td class="rightTd">&dollar; <fmt:formatNumber type="number"
								maxFractionDigits="2" value="${overallPrice}" /></td>
					</tr>

					<tr>
						<td>SHIPPING</td>

						<td class="rightTd"><c:choose>
								<c:when test="${overallPrice>100}">
					FREE
					</c:when>
								<c:otherwise>
						&dollar; 10
					</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td id="estTotal">EST.TOTAL</td>

						<td id="estTotalRightTd"><c:choose>
								<c:when test="${overallPrice>100}">
					&dollar; <fmt:formatNumber type="number" maxFractionDigits="2"
										value="${overallPrice}" />
								</c:when>
								<c:otherwise>
						&dollar; <fmt:formatNumber type="number" maxFractionDigits="2"
										value="${overallPrice + 10}" />
								</c:otherwise>
							</c:choose></td>
					</tr>

					<c:forEach var="tempProduct" items="${cartProducts}">

						<c:url var="productPage" value="/main/showProduct">
							<c:param name="productId">
						${tempProduct.product.id}
					</c:param>
						</c:url>

						<tr>
							<td><a href="${productPage}">
									${fn:substring(tempProduct.product.name,0,20)} </a> <c:if
									test="${fn:length(tempProduct.product.name) > 20}">...</c:if>
								(x ${tempProduct.quantity})</td>
							<td class="rightTd">&dollar;<fmt:formatNumber type="number"
									maxFractionDigits="2" value="${tempProduct.price}" />
							</td>
						</tr>
					</c:forEach>

				</table>

			</div>


		</div>

		<div style="clear: both"></div>

		<div id="continue">
			<div id="continueContent">Continue</div>
			<a href="/logged/showCheckoutPaymentMethod">
						<span class="link-spanner"></span>
					</a>
		</div>

		<hr id="firstHr">

		<div class="unactiveLabel">
			<img style="vertical-align: middle"
				src="/css/img/number-three-in-a-circle-grey.png"> Enter
			payment method
		</div>


	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		
		$('#continue').hide();
		
		$('#defaultAddressCheckbox').change(function() {
			if ($(this).prop("checked")) {
				$('#addressForm').hide();
				$('#continue').show();
			} else {
				$('#addressForm').show();
				$('#continue').hide();
			}
		});
	});
</script>

</html>