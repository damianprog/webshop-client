<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="/css/account.css" type="text/css" />
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


		<jsp:include page='/view/accountSideTable.jsp' />

		<div id="contentDiv">

			<h2>Purchase History</h2>
			<c:choose>
				<c:when test="${empty orders}">
					<span style="font-size: 20px;">You didn't place any orders
						yet!</span>
				</c:when>

				<c:otherwise>
					<table id="ordersTable">

						<tr>
							<th>Products</th>
							<th>Price</th>
							<th>Date of Order</th>
							<th>Details</th>
						</tr>

						<c:forEach var="order" items="${orders}">

							<c:url var="fullOrder" value="/account/showFullOrder">
								<c:param name="orderId">${order.id}</c:param>
							</c:url>

							<tr>
								<td><c:forEach begin="0" end="1" var="cartProduct"
										items="${order.cartProducts}">
						${fn:substring(cartProduct.product.name,0,30)}
						<c:if test="${fn:length(cartProduct.product.name) > 30}">...</c:if>
										<br>
									</c:forEach></td>

								<td>&dollar; <fmt:formatNumber type="number"
										maxFractionDigits="2" value="${order.overallValue}" /></td>

								<td>${order.orderDate}</td>

								<td><a href="${fullOrder}">Check Full Order</a></td>

							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>

			<hr>

			<h2>Manage Your Account</h2>

			<table id="contentTable">

				<tr>
					<td><a class="aAccountContent"
						href="/account/showAddOrEditPaymentMethod"> <img class="icon"
							src="/css/img/credit-card.png">Add or edit a payment method
					</a></td>
				</tr>

				<tr>
					<td><a class="aAccountContent"
						href="/account/showShippingAddress"><img class="icon"
							src="/css/img/delivery-truck.png">Add or edit a shipping
							address</a></td>
				</tr>

				<tr>
					<td><img class="icon" src="/css/img/profile.png">Make
						changes to your profile</td>
				</tr>

				<tr>
					<td><img class="icon" src="/css/img/locked.png">Change
						your password</td>
				</tr>
			</table>

		</div>

	</div>
</body>


</html>