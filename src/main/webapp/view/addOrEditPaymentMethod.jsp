<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/addOrEditPaymentMethod.css"
	type="text/css" />
<link rel="stylesheet" href="/css/css/fontello.css" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text|Noto+Serif:400i&amp;subset=latin-ext"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Cabin"
	rel="stylesheet">
<script src="/css/js/jquery-3.3.1.min.js"></script>
</head>

<body>

	<div id="container">

		<jsp:include page="/view/header.jsp" />

		<div style="clear: both"></div>

		<div id="headerInfo">
			<img style="vertical-align: middle"> Manage your credit cards
		</div>

		<c:if test="${!empty noCreditCards}">
			<div id="underHeaderInfo">We see you haven't saved a credit
				card to your account. Make your next checkout experience faster by
				adding a one now.</div>
		</c:if>

		<form:form action="/account/savePaymentMethod"
			modelAttribute="creditCard" method="POST">

			<input type="hidden" name="updateCreditCard" value="${updateCreditCard}">

			<div id="leftTable">

				<div id="cardLabel">Card information</div>

				<c:choose>
				
					<c:when test="${creditCard.itDefault == false}">
						<input name="setAsDefaultCreditCard" type="checkbox">Set as
						default credit card
					</c:when>
				
					<c:otherwise>
						This is your default credit card
						<input type="hidden" name="setAsDefaultCreditCard" value="true">
					</c:otherwise>
				
				</c:choose>

				

				<table id="shippingAddressesTable">

					<form:hidden path="id" />
					<tr>
						<td>First Name on card*<br /> <form:input path="firstName"
								placeholder="First Name" class="inputBoxShippingAddresses"
								required="required" />
						</td>
					</tr>

					<tr>
						<td>Last Name on card*<br /> <form:input path="lastName"
								placeholder="Last Name" class="inputBoxShippingAddresses"
								required="required" />
						</td>
					</tr>

					<tr>
						<td>Card number*<br /> <form:input path="cardNumber"
								placeholder="Card Number" class="inputBoxShippingAddresses"
								required="required" />
						</td>
					</tr>

					<tr>
						<td><img src="/css/img/creditcards.png"></td>
					</tr>

					<tr>
						<td>

							<div id="expirationDateDiv">
								Expiration Date*<br />
								<form:select path="monthExpiration" class="dropDown"
									required="required">
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</form:select>

								<form:select path="yearExpiration" class="dropDown"
									required="required">
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
								</form:select>
							</div>

							<div id="securityCodeDiv">
								Security Code*<br />
								<form:input path="securityCode" placeholder="Security Code"
									class="inputBoxSecurityCode" required="required" />
							</div>
						</td>
					</tr>

					<tr>
						<td>Phone number*<br /> <form:input path="phoneNumber"
								placeholder="Phone Number" class="inputBoxShippingAddresses"
								required="required" />
						</td>
					</tr>

					<tr>
						<td><input id="continueSubmit" type="submit" value="Continue" />
						</td>
					</tr>

				</table>


			</div>

			<div id="rightTable">
				<div id="billingLabel">Billing Address</div>
				<br> <input id="billingCheckbox" type="checkbox"
					name="setDefaultAddress" checked> Set default address
				<input type="hidden" name="addressId" value="${address.id}">
				<div id="billingAddress">
					${address.firstName} ${address.lastName}<br> ${address.city},
					${address.country} ${address.postCode}
				</div>

				<table id="billingAddressTable">

					<tr>
						<td>Street Address*<br /> <input name="street"
							placeholder="Street Address" class="inputBoxShippingAddresses" />
						</td>
					</tr>

					<tr>
						<td>City*<br /> <input name="city" placeholder="City"
							class="inputBoxShippingAddresses" />
						</td>
					</tr>

					<tr>
						<td>

							<div id="country">
								Country* <br /> <input name="country" placeholder="Country"
									class="inputBoxShippingAddressesSmaller" />
							</div>

							<div id="postCode">
								Post Code* <br /> <input name="postCode"
									placeholder="Post Code"
									class="inputBoxShippingAddressesSmaller" />
							</div>

						</td>

					</tr>

				</table>

			</div>
		</form:form>
		
	</div>

	<div style="clear: both"></div>

	<hr id="firstHr">

</body>

<script type="text/javascript">
	$(document).ready(function() {

		$('#billingAddressTable').hide();

		$('#billingCheckbox').change(function() {
			if ($(this).prop("checked")) {
				$('#billingAddressTable').hide();
				$('#billingAddress').show();
			} else {
				$('#billingAddressTable').show();
				$('#billingAddress').hide();
			}
		});
	});
</script>

</html>