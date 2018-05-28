<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/writeReview.css" type="text/css" />
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

		<form:form action="/customer/saveReviewAndRating"
			modelAttribute="review" method="POST">
			<jsp:include page='/view/header.jsp' />



			<div id="welcome">
				<div class="header">Hi ${userFirstName}!</div>
				<div class="infoText">Your review will help other shoppers
					make better purchase decisions.</div>

				<div id="productPhoto">
					<img src="data:img/jpeg;base64,${productPhoto}">
				</div>

				<div id="productName">${product.name}</div>

				<div class="header">How would you rate this?</div>

				<div id="ratingDiv">
					Rate <select name="rate">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5" selected="selected">5</option>
					</select>

				</div>
			</div>
			<div id="boxes">
				<div id="review">
					<div id="improvementQuestion"></div>

					<form:textarea id="reviewBox" required="required" path="review"
						placeholder="Share some details to help other shoppers!"></form:textarea>
				</div>

				<div id="nickname">
					<div class="boxLabel"><b>Nickname</b>(we will display this name with
						your review)</div>

					<form:input type="text" path="nickname" class="input"></form:input>

				</div>
				
				<div id="reviewTitleDiv">
					<div class="boxLabel"><b>Review Title</b></div>

					<form:input type="text" path="reviewTitle" id="reviewTitleInput"></form:input>

				</div>
				
				<div id="submitReviewDiv">
				
				<input type="hidden" name="productId" value="${product.id}">
				
					<input type="submit" value="Submit Review" id="submitReview">
					
					<hr style="margin-top:20px;margin-bottom:20px;">
					By submitting this review, you are agreeing to our review term & guidelines
				</div>
				
			</div>
		</form:form>
	</div>