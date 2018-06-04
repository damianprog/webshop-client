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
	<script src="/css/js/jquery-3.3.1.min.js"></script>
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
				<c:forEach var="tempCreditCard" items="${creditCardsList}">
					<div id="creditCardDiv">
						<div id="masterCardLogo">
							<img src="/css/img/masterCardBigger.png">
						</div>


						<div id="details">

							<div id="firstNameAndLastName">${tempCreditCard.firstName}
								${tempCreditCard.lastName}</div>
							<br>

							<div id="cardNumber">${fn:substring(tempCreditCard.cardNumber,0,4)}
								**** **** ****</div>

							<div id="securityCode">***</div>
						</div>

						<div id="editAndRemove">

							<div class="edit">
								<form class="editForm" action="/account/editCreditCard" method="POST">
									<input type="hidden" name="creditCardId"
										value="${tempCreditCard.id}"> 
										
									<input type="submit" value="Edit">	
								</form>
							</div>
							
							<br>

							<div class="remove">
								<form class="removeForm" action="/account/removeCreditCard" method="POST">
									<input type="hidden" name="creditCardId"
										value="${tempCreditCard.id}"> 
										
										<input type="submit" value="Remove">	
								</form>
							</div>

						</div>
					</div>
					<div style="clear:both"></div>
				</c:forEach>
			</div>

		</div>
	</div>
</body>

<script type="text/javascript">
// $(document).ready(function () {
	 
// 	$( ".edit" ).click(function() {
// 		  $( ".editForm" ).submit();
// 	});
	
// 	$( ".remove" ).click(function() {
// 		  $( ".removeForm" ).submit();
// 	});


// });
</script>

</html>