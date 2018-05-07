<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="/css/login.css" type="text/css" />
<link rel="stylesheet" href="/css/css/fontello.css" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Lobster"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text|Noto+Serif:400i&amp;subset=latin-ext"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Cabin"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto|Spectral+SC"
	rel="stylesheet">
</head>


<body>

	<div id="container">

		<div id="logo">
			<a href="/main/start"><img src="/css/img/logo.jpg" /></a>
		</div>

		<div id="header">
			<h1>Sign in to your account</h1>
		</div>

		<div id="inputsContainer">

			<c:choose>

				<c:when test="${!empty error}">
					<table id="errorInfoTable">
						<tr>
							<td><h3>Login or password is not correct</h3>
								<p>Make sure your account is email-activated
								<p></td>
						</tr>

						<tr>
							<td><a href="/login">Go back to login page</a></td>
						</tr>
					</table>
				</c:when>


				<c:otherwise>
					<form:form method="POST" action="/login">

						<table>
							<tr>
								<td>Name</td>
							</tr>
							<tr>
								<td class="inputCells"><input name="username" type="text"
									placeholder="Name" class="inputBox" required="required" /></td>
							</tr>
							<tr>
								<td>Password</td>
							</tr>
							<tr>
								<td class="inputCells"><input name="password"
									type="password" placeholder="Password" class="inputBox"
									required="required" /></td>
							</tr>

							<tr>
								<td id="forgotLabel">Forgot Password?</td>
							</tr>

							<tr>
								<td id="joinSubmitTd"><input id="signIn" type="submit"
									value="Sign In" /></td>
							</tr>

							<tr>
								<td id="accountLabel">Don't have an account?</td>
							</tr>

							<tr>
								<td><div id="createAccount">
										<span id="createAccountText"><a id="spanCAT"
											href="/main/signUp">Create a new account</a></span>
									</div></td>
							</tr>

						</table>

					</form:form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>


</body>

</html>