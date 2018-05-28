<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="/css/creditCardsList.css" type="text/css" />
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

		<div id="creditCardsListContent">
			<div id="creditCardsListHeader">
				<h2>Your credit cards list</h2>
			</div>

			<div id="creditCardsList">
				<c:forEach var="creditCard" items="${creditCardsList}">
					<div id="creditCard">
						<div id="masterCardLogo">
							<img src="/css/img/masterCardBigger.png">
						</div>

						<c:url var="editCreditCard" value="/account/editCreditCard">
							<c:param name="creditCardId">${creditCard.id}</c:param>
						</c:url>
						
						<c:url var="removeCreditCard" value="/account/removeCreditCard">
							<c:param name="creditCardId">${creditCard.id}</c:param>
						</c:url>

						<div id="details">

							<div id="firstNameAndLastName">${creditCard.firstName} ${creditCard.lastName}</div>
							<br>
							
							<div id="cardNumber">${fn:substring(creditCard.cardNumber,0,4)} **** **** ****</div>
	
							<div id="securityCode">***</div>
						</div>
						
						<div id="editAndRemove">
						
							<div id="edit">
								<a href="${editCreditCard}">Edit</a>
							</div>
							
							<br>
							
							<div id="remove">
								<a href="${removeCreditCard}">Remove</a>
							</div>
							
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
</body>


</html>