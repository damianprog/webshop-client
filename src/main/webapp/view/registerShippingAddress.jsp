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

		<h2>Provide your default shipping address</h2>
		<div id="addressesDescription">For a quicker checkout
			experience, enter and save your shipping address now. You can save
			multiple addresses here and select the one you want when you place
			your order.</div>

		<div class="greySmallText">* required field</div>

		<form:form action="/main/saveUser"
			modelAttribute="userDetails" method="POST">

			<table id="shippingAddressesTable">
				<form:hidden path="id" />
				<form:hidden path="address.id" />
				<tr>
					<td>First Name*<br /> <form:input path="address.firstName"
							placeholder="First Name" class="inputBoxShippingAddresses"
							required="required" />
					</td>

					<td class="rightTd">Street Address*<br /> <form:input
							path="address.street" placeholder="Street Address"
							class="inputBoxShippingAddresses" required="required" />
					</td>
				</tr>

				<tr>
					<td>Last Name*<br /> <form:input path="address.lastName"
							placeholder="Last Name" class="inputBoxShippingAddresses"
							required="required" />
					</td>

					<td class="rightTd">City*<br /> <form:input path="address.city"
							placeholder="City" class="inputBoxShippingAddresses"
							required="required" />
					</td>
				</tr>

				<tr>
					<td>Phone*<br /> <form:input path="address.phone" placeholder="Phone"
							class="inputBoxShippingAddresses" required="required" />
					</td>
					<td class="rightTd">Country*<br /> <form:input path="address.country"
							placeholder="Country" class="inputBoxShippingAddresses"
							required="required" />
					</td>
				</tr>

				<tr>
					<td>Post-Code*<br /> <form:input path="address.postCode"
							placeholder="Post-Code" class="inputBoxShippingAddresses"
							required="required" />
					</td>
				</tr>
			</table>

			<input id="saveAddress" type="submit" value="Create Account" />
		</form:form>
	</div>
</body>


</html>