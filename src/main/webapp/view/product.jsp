<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript" src="/css/js/jquery-3.3.1.min.js"></script>
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

			<form action="/cart/addToCart">

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
							name="carePlan"> Add <b>2-Year</b> Device Protection <b>&dollar;
								2.00</b>

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
	

	<div class="rightSide">
		<c:url var="sponsoredPage" value="/main/showProduct">
			<c:param name="productId">${sponsored.id}</c:param>
		</c:url>


		<table id="sponsored">
			<tr>
				<td><a href="${sponsoredPage}"> <img
						src="data:img/jpeg;base64,${sponsoredPhoto}">
				</a></td>
				<td>
					<table id="sponsoredContentTable">
						<tr>
							<td>Sponsored by ${sponsored.brand}</td>
						</tr>
						<tr>
							<td><a href="${sponsoredPage}"> ${sponsored.name} </a></td>
						</tr>
						<tr>
							<td>&dollar; ${sponsored.price}</td>
						</tr>
						<tr>
							<td>Rating: <fmt:formatNumber type="number" maxFractionDigits="1"
									value="${sponsoredRating}" /> Reviews: ${sponsoredReviewsCount}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>

	<div style="clear:both"></div>

<hr style="margin:30px 0 40px 0;">

<div id="customerReviews">
	<div id="customerReviewsLabel">
		Customer Reviews
	</div>
	
	<div id="rating">
		Average Rating <fmt:formatNumber type="number" maxFractionDigits="1"
									value="${averageRating}" /> out of 5
	</div>
	
	<div id="writeReview">
		<div id="writeReviewContent">
			Write Review
		</div>
		
		<c:url var="writeReview" value="/customer/writeReview">
			<c:param name="productId">${product.id}</c:param>
		</c:url>
		
		<a href="${writeReview}">
			<span id="link-spanner"></span>
		</a>
	</div>
	
	<div style="clear:both;"></div>
	
	<div id="reviewsCount">
		${reviews.size()} Reviews
	</div>
	
	<hr style="margin:30px 0 40px 0;">
	
	<div id="reviews">
		
		<table id="reviewsTable">
			
			<c:forEach var="review" items="${reviews}">
			<tr>
				<td style="padding-top:20px;">
					<div id="reviewTitle">
						${review.reviewTitle}
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div id="reviewRating">
						Rated it ${review.rating.rate}
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div style="font-size: .875rem;
						word-wrap:break-word;
						display: block;
						overflow:hidden;
						height:107px;" id="reviewText${review.id}">
						${review.review}
					</div><br>
					<c:if test="${review.review.length() > 695}">
								<a class="moreDesc" data-value="reviewText${review.id}">More...</a>
							</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
		
	</div>
	
	<c:forEach begin="1" end="${reviewsPage.totalPages}" var="i">
			<c:url var="page" value="/main/showProduct">
				<c:param name="page" value="${i}"></c:param>
				<c:param name="productId" value="${product.id}"></c:param>
			</c:url>
			<h3 id="pageNum">
				<a href="${page}">${i}</a>
			</h3>
		</c:forEach>
	
</div>

</div>
</body>

<script src="/css/js/showmore.js"></script>

<script type="text/javascript">
	function alertCart() {
		alert("This item has been added to your cart");
	}
</script>


</html>