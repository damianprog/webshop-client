<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="/css/signup.css" type="text/css" />
<link rel="stylesheet" href="/css/css/fontello.css" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text|Noto+Serif:400i&amp;subset=latin-ext"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Cabin"
	rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto|Spectral+SC" rel="stylesheet">
</head>


<body>

	<div id="container">

		<div id="logo">
			<a href="/main/start"><img src="/css/img/logo.jpg" /></a>
		</div>

		<div id="create">
			<h1>Create your account</h1>
		</div>

		<div id="inputsContainer">

			<form:form action="saveUser" modelAttribute="user" method="POST">

				<table id="inputsTable">
					<tr>
						<td id="first">* required field</td>
					</tr>
					<tr>
						<td class="labels">*Name (6-20 Characters)</td>
					</tr>
					<tr>
						<td><form:errors path="userName" cssClass="error" /></td>
					</tr>
					<tr>
						<td class="inputCells"><form:input path="userName"
								placeholder="Name" class="inputBox" required="required" /></td>
					</tr>

					<tr>
						<td class="labels">*Password (6-20 Characters)</td>
					</tr>
					<tr>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>
					<tr>
						<td class="inputCells"><form:password path="password"
								placeholder="Password" class="inputBox" required="required" /></td>
					</tr>

					<tr>
						<td class="labels">*Email</td>
					</tr>
					<tr>
						<td><form:errors path="email" cssClass="error" /></td>
					</tr>
					<tr>
						<td class="inputCells"><form:input path="email"
								placeholder="Email" class="inputBox" required="required" /></td>
					</tr>
				</table>

				<div id="terms">By clicking Create Account, you acknowledge
							you have read and agreed to our Terms of Use and Privacy Policy.</div>
							
				<input id="signUp" type="submit" value="Create Account"/>

			</form:form>
		</div>
	</div>


</body>

</html>