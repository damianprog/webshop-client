<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="/css/shippingAddresses.css" type="text/css" />
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

		<div id="pageInfoHeader">
			<a class="blueHref" href="/profile/showAccount">Your Account</a> >
			Shipping Addresses
		</div>

		<h2>Manage your shipping addresses</h2>
		<div id="addressesDescription">For a quicker checkout
			experience, enter and save your shipping address now. You can save
			multiple addresses here and select the one you want when you place
			your order.</div>

		<div class="greySmallText">* required field</div>

		<form:form action="/account/saveShippingAddress"
			modelAttribute="userDetails" method="POST">

			<table id="shippingAddressesTable">
				<form:hidden path="id" />
				<tr>
					<td>First Name*<br /> <form:input path="firstName"
							placeholder="First Name" class="inputBoxShippingAddresses"
							required="required" />
					</td>

					<td class="rightTd">Street Address*<br /> <form:input
							path="street" placeholder="Street Address"
							class="inputBoxShippingAddresses" required="required" />
					</td>
				</tr>

				<tr>
					<td>Last Name*<br /> <form:input path="lastName"
							placeholder="Last Name" class="inputBoxShippingAddresses"
							required="required" />
					</td>

					<td class="rightTd">City*<br /> <form:input path="city"
							placeholder="City" class="inputBoxShippingAddresses"
							required="required" />
					</td>
				</tr>

				<tr>
					<td>Phone*<br /> <form:input path="phone" placeholder="Phone"
							class="inputBoxShippingAddresses" required="required" />
					</td>
					<td class="rightTd">Country*<br /> <form:input path="country"
							placeholder="Country" class="inputBoxShippingAddresses"
							required="required" />
					</td>
				</tr>

				<tr>
					<td>Post-Code*<br /> <form:input path="postCode"
							placeholder="Post-Code" class="inputBoxShippingAddresses"
							required="required" />
					</td>
				</tr>
			</table>

			<input id="saveAddress" type="submit" value="Save Address" />
		</form:form>
	</div>
</body>


</html>