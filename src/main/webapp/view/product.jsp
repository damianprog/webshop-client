<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/product.css" type="text/css" />
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

		<jsp:include page='/view/header.jsp' />

		<div class="leftSide">

			<div id="productName">${product.name}</div>

			<div id="productPhoto">
				<img src="data:img/jpeg;base64,${productPhoto}">
			</div>

		</div>

		<div class="rightSide">

			<form action="/logged/addToCart">

				<table class="saleTable">

					<tr>
						<td>&dollar; ${product.price}

							<div id="soldDesc">Sold &amp; shipped by Shop-Electronics</div>
						</td>
					</tr>
					<tr>
						<td><b>FREE SHIPING</b><br> Arrives by ${arrivesDate}</td>
					</tr>
					<tr>
						<td>Free pickup not available from this seller</td>
					</tr>
					<tr>
						<td>Protect your device from drops &amp; spills with <b>Care
								Plan</b> <br> <br> <input id="carePlan" type="checkbox"
							name="carePlan"> Add <b>2-Year</b> Headphones Protection
							<b>&dollar; 2.00</b>

						</td>
					</tr>
					<tr>
						<td>
							<div style="float: left">
								Quantity: <select id="quantity" name="quantity">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>

								</select>
							</div> <input type="hidden" name="productId" value="${product.id}">

							<sec:authorize access="isFullyAuthenticated()">
								<input id="addToCart" type="submit" value="Add to cart"
									onclick="alertCart()">
							</sec:authorize> <sec:authorize access="!isFullyAuthenticated()">
								<input id="addToCart" type="submit" value="Add to cart">
							</sec:authorize>

						</td>
					</tr>

				</table>
			</form>
		</div>
		<div style="clear: both"></div>
		<div class="leftSide">
			<div id="highlights">

				<h3>Highlights</h3>

				<ul>
					<c:forEach var="highlight" items="${highlights}">
						<li>${highlight}</li>
					</c:forEach>
				</ul>
			</div>

			<div id="description">

				<h3>Description</h3>

				${product.description}
			</div>

		</div>
	</div>

	<div class="rightSide">
		<c:url var="sponsoredPage" value="/main/showProduct">
			<c:param name="productId">${sponsored.id}</c:param>
		</c:url>


		<table id="sponsored">
			<tr>
				<td>
					<div style="float: left;">
						<a href="${sponsoredPage}"> <img
							src="data:img/jpeg;base64,${sponsoredPhoto}">
						</a>
					</div>
					<div id="sponsoredDescription">
						Sponsored by ${sponsored.brand} <br> <a
							href="${sponsoredPage}"> ${sponsored.name} </a> <br>
						&dollar; ${sponsored.price} <br> Rating: Reviews:

					</div>
				</td>
			</tr>
		</table>
	</div>

</body>

<script type="text/javascript">
	function alertCart() {
		alert("This item has been added to your cart");
	}
</script>


</html>