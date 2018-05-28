<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="/css/fullOrder.css" type="text/css" />
<link rel="stylesheet" href="/css/css/fontello.css" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text|Noto+Serif:400i&amp;subset=latin-ext"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto|Spectral+SC"
	rel="stylesheet">
</head>


<body>

	<div id="container">

		<jsp:include page='/view/header.jsp' />

		<div id="sideTablesDiv">

			<div id="infoLabel">
				<h3>Your Account</h3>
			</div>

			<div>
				<h4>Manage Account</h4>
			</div>

			<table class="sideTable">

				<tr>
					<td>
					<a class="blueHref" href="/account/showAccount">
					Purchase History
					</a>
					</td>
				</tr>

				<tr>
					<td>Profile &amp; Password</td>
				</tr>

				<tr>
					<td><a class="blueHref" href="/account/showShippingAddress">Shipping
							Addresses</a></td>
				</tr>

				<tr>
					<td>Payment Methods</td>
				</tr>

				<tr>
					<td>Gift Cards</td>
				</tr>

			</table>

			<sec:authorize access="hasAuthority('ADMIN')">

				<div>
					<h4>Admin Actions</h4>
				</div>

				<table class="sideTable">

					<tr>
						<td><a class="blueHref" href="/admin/addProduct">Add
								Product</a></td>
					</tr>

				</table>

			</sec:authorize>

			<div>
				<h4>Customer Service</h4>
			</div>

			<table class="sideTable">

				<tr>
					<td>Help</td>
				</tr>

				<tr>
					<td>Contact Us</td>
				</tr>
			</table>
		</div>

		<div id="contentDiv">

			<h2>Order Details</h2>

			<c:forEach var="cartProduct" items="${order.cartProducts}">


				<c:url var="productPageLink" value="/main/showProduct">
					<c:param name="productId">${cartProduct.product.id}</c:param>
				</c:url>

				<div id="cartProduct">
					<div id="cartProductPhoto">
						<img
							src="data:img/jpeg;base64,${cartProduct.product.encodedProductPhoto}">

					</div>

					<table id="cartProductTable">
						<tr>
							<td><a id="aProduct" href="${productPageLink}">${fn:substring(cartProduct.product.name,0,33)}
									<c:if test="${fn:length(cartProduct.product.name) > 33}">...</c:if>
							</a></td>
						</tr>
						<tr>
							<td id="soldByTd"><span
								style="font-weight: bold; color: #666;">Sold By:</span> <span
								style="color: #666;">Shop-Electronics</span></td>
						</tr>
					</table>

					<div id="priceAndQuantity">
						<div id="quantity">Quantity: ${cartProduct.quantity}</div>
						<div id="price">
							Price: <b>&dollar; <fmt:formatNumber type="number"
									maxFractionDigits="2" value="${cartProduct.price}" /></b>
						</div>
					</div>
					<div style="clear: both"></div>
				</div>
			</c:forEach>

			<hr>

			<div id="deliveryLabels">
				<div id="deliveryLabel">Delivery: 2-day-shipping</div>

				<div id="priceWithDeliveryLabel">Price with delivery</div>
			</div>
			<div id="deliveryCosts">
				<div id="deliveryCost">FREE</div>

				<div id="priceWithDelivery">&dollar; ${order.overallValue}</div>
			</div>

			<hr>

			<div id="deliveryAddressDiv">


				<div id="address">
					<p class="greyHeader">Delivery Address</p>
					${order.address.firstName} ${order.address.lastName}<br>
					${order.address.country} ${order.address.city}
					${order.address.street}<br> ${order.address.postCode}
				</div>

				<div id="phoneNumber">
					<p class="greyHeader">the recipent's phone number</p>
					${order.address.phone}
				</div>

			</div>

			<div style="clear: both"></div>
			<br>

			<hr>
			<div id="paymentDiv">
				<p class="greyHeader">Payment</p>
				<div id="paymentMethodDiv">
					<span style="color: #666;">payment method</span><br>
					<div id="creditCardLabels">
						VISA MASTERCARD<br> Shop-Electronics Payments
					</div>
				</div>

				<div id="paymentCompletedDiv">
					<span style="color: #666;">payment completed</span><br>
					${order.orderDate}
				</div>

				<div id="paymentAmountDiv">
					<span style="color: #666;">payment amount</span><br> &dollar;
					${order.overallValue}
				</div>

			</div>

		</div>

	</div>
</body>


</html>