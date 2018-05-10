<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/checkoutShippingType.css"
	type="text/css" />
<link rel="stylesheet" href="/css/css/fontello.css" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text|Noto+Serif:400i&amp;subset=latin-ext"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Cabin"
	rel="stylesheet">

</head>

<body>

	<div id="container">

		<jsp:include page="/view/header.jsp" />

		<div id="leftSide">
			<div id="headerInfo">
				<img style="vertical-align: middle"
					src="/css/img/number-one-in-a-circle.png"> Shipping Options
			</div>

			<div class="shippingTypeBox">
				<div class="shippingTypeBoxContent">Shipping</div>
			</div>

			<div id="productsPhotos">

				<c:forEach var="tempProduct" items="${cartProducts}">

					<div id="productPhoto">
						<img
							src="data:img/jpeg;base64,${tempProduct.product.encodedProductPhoto}">
					</div>

				</c:forEach>
			</div>

			<div id="arriveBy">
				<div id="arriveByLabel">Arrive by</div>
				<div class="shippingType">
					<div id="shippingTypeContentDate">${arrivesDate}</div>
					<div id="shippingTypeContentPriceInfo">
						<c:choose>
							<c:when test="${overallPrice > 100}">
							Free
						</c:when>
							<c:otherwise>
							&dollar; 10
						</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>

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
		</div>
		
		<hr id="firstHr">

		<div class="unactiveLabel">
			<img style="vertical-align:middle" src="/css/img/number-two-in-a-circle-grey.png"> Enter shipping address
		</div>

		<hr>

		<div class="unactiveLabel">
			<img style="vertical-align:middle" src="/css/img/number-three-in-a-circle-grey.png"> Enter payment method
		</div>

	</div>
</body>

</html>