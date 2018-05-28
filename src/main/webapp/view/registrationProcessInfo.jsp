<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Join</title>
<link type="text/css" rel="stylesheet" href="/css/created.css" />
<link href="https://fonts.googleapis.com/css?family=Roboto|Spectral+SC"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto|Spectral+SC"
	rel="stylesheet">
</head>

<body>
	<div id="container">

		<div id="logo">
			<a href="/main/start"><img src="/css/img/logo.jpg" /></a>
		</div>

		<div id="roundedContainer">

			<c:choose>
				<c:when test="${success == true }">
					<h3>You've been successfully Registered</h3>
					<p>The authentication link has been sent to given email</p>
					<p>
						<a href="/main/start">Shop-Electronics Home</a>
					</p>
					<p>or</p>
					<p>
						<a href="/login">Login Page</a>
					</p>
				</c:when>
				<c:otherwise>
					<h3>This login is taken</h3>
					<p>
						<a href="/main/signUp">Go back to Register page</a>
					</p>

				</c:otherwise>

			</c:choose>
		</div>

	</div>
</body>

</html>