<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/cart.css" type="text/css" />
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

		<div id="checkoutDiv">
			<table id="priceInfoTable">

				<tr>
					<td>SUBTOTAL (${overallQuantity} 
				Items
					</td>

					<td class="rightTd">&dollar; <fmt:formatNumber type="number" maxFractionDigits="2"
									value="${overallPrice}" /></td>
				</tr>

				<tr>
					<td>SHIPPING</td>

					<td class="rightTd"><c:choose>
							<c:when test="${overallPrice>100}">
					FREE
					</c:when>
							<c:when test="${overallPrice == 0}">
					&dollar; 0
					</c:when>
							<c:otherwise>
						&dollar; 10
					</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<td>EST.TOTAL</td>

					<td class="rightTd"><c:choose>
							<c:when test="${overallPrice>100}">
					&dollar; <fmt:formatNumber type="number" maxFractionDigits="2"
									value="${overallPrice}" />
					</c:when>
					<c:when test="${overallPrice == 0}">
						&dollar; 0
					</c:when>
							<c:otherwise>
						&dollar; <fmt:formatNumber type="number" maxFractionDigits="2"
									value="${overallPrice + 10}" />
					</c:otherwise>
						</c:choose></td>
				</tr>

			</table>

			<c:if test="${!empty cartProducts}">
				<div id="checkout">
					<div id="checkoutContent">Check Out</div>
					<a href="/logged/showCheckoutShippingType">
						<span class="link-spanner"></span>
					</a>
				</div>
			</c:if>

		</div>

		<div id="descLabel">
			Your cart: <span id="boldNavyBlue">${overallQuantity} <c:choose>
					<c:when test="${overallQuantity > 1}">
				Items
			</c:when>
					<c:otherwise>
				Item
			</c:otherwise>
				</c:choose>
			</span>
		</div>

		<c:forEach var="cartProduct" items="${cartProducts}">

			<c:url var="productPageLink" value="/main/showProduct">
				<c:param name="productId">${cartProduct.product.id}</c:param>
			</c:url>

			<c:url var="removeCartProduct" value="/logged/removeCartProduct">
				<c:param name="productId">${cartProduct.product.id}</c:param>
			</c:url>
			<div id="cartProduct">
				<div id="cartProductPhoto">
					<img
						src="data:img/jpeg;base64,${cartProduct.product.encodedProductPhoto}">

				</div>

				<table id="cartProductTable">
					<tr>
						<td><a id="aProduct" href="${productPageLink}">${cartProduct.product.name}</a></td>
					</tr>
					<tr>
						<td><span style="font-weight: bold; color: #666;">Sold
								By:</span> <span style="color: #666;">Shop-Electronics</span></td>
					</tr>
					<tr>
						<td><span id="price">&dollar; <fmt:formatNumber type="number" maxFractionDigits="2"
									value="${cartProduct.price}" /></span></td>
					</tr>
					<tr>
						<td>2-DAY SHIPPING | PICKUP TODAY</td>
					</tr>
				</table>

				<div id="quantity">Quantity: ${cartProduct.quantity}</div><br>

				<div id="remove">
					<a id="aRemove" href="${removeCartProduct}">Remove</a>
				</div>

			</div>
			<div style="clear:both"></div>
		</c:forEach>

	</div>

</body>

</html>