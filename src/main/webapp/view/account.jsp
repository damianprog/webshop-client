<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

		<div id="sideTablesDiv">

			<div id="infoLabel">
				<h3>Your Account</h3>
			</div>

			<div>
				<h4>Manage Account</h4>
			</div>

			<table class="sideTable">

				<tr>
					<td>Purchase History</td>
				</tr>

				<tr>
					<td>Profile &amp; Password</td>
				</tr>

				<tr>
					<td><a class="blueHref" href="/account/showShippingAddress">Shipping Addresses</a></td>
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
						<td><a class="blueHref" href="/admin/addProduct">Add Product</a></td>
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

			<h2>Purchase History</h2>

			<c:choose>

				<c:when test="${empty orders}">
					<span style="font-size: 20px;">You didn't place any orders
						yet!</span>
				</c:when>

			</c:choose>

			<hr>

			<h2>Manage Your Account</h2>

			<table id="contentTable">

				<tr>
					<td><img class="icon" src="/css/img/credit-card.png">Add
						or edit a payment method</td>
				</tr>

				<tr>
					<td><a class="aAccountContent" href="/account/showShippingAddress"><img class="icon" src="/css/img/delivery-truck.png">Add
						or edit a shipping address</a></td>
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