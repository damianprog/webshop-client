<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="/css/accountSideTable.css" type="text/css" />
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


		<div id="sideTablesDiv">
			
			<h3>Account Actions</h3>

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
					<td><a class="blueHref" href="/account/showShippingAddress">Shipping
							Addresses</a></td>
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
						<td><a class="blueHref" href="/admin/addProduct">Add
								Product</a></td>
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
		
		
</body>


</html>