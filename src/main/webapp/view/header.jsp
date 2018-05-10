<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
<link rel="stylesheet" href="/css/header.css" type="text/css" />
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

	<table id="headerTable">
		<tr>
			<td>
				<div id="logo">
					<a href="/main/start"><img src="/css/img/logo.jpg" /></a>
				</div>
			</td>


			<td>
				<div id="logreg">



					<sec:authorize access="isFullyAuthenticated()">
						<table id="loggedTable">
							<tr>
								<td><a href="/account/showAccount"> <img
										style="vertical-align: middle;" src="/css/img/account.png">
										${sessionScope.userSession.userName}
								</a></td>
								<td>
								<a href="/logged/showCart">
								<img style="vertical-align: middle;"
									src="/css/img/cart.png"> Cart
								</a>	
								</td>
								<td><a style="text-decoration: none" href="/logout"> <img
										style="vertical-align: middle;" src="/css/img/logout.png">Logout
								</a></td>
							</tr>

						</table>
					</sec:authorize>

					<sec:authorize access="!isFullyAuthenticated()">
						<form:form method="POST" action="/login">
							<table id="inputs">
								<tr>
									<td><input type="text" placeholder="Login"
										class="inputBox" required="required" name="username" /></td>
									<td><input type="password" placeholder="Password"
										class="inputBox" required="required" name="password" /></td>
									<td><input class="signInHeader" type="submit"
										value="Sign In" /></td>
								</tr>
								<tr>
									<td id="cbMain"><input type="checkbox" name="cb"
										value="remember" /> Remember me</td>
									<td id="cbMainForgot"><a
										style="text-decoration: underline;" href="/main/signUp">Sign
											Up</a></td>
								</tr>
							</table>
						</form:form>
					</sec:authorize>
				</div>
			</td>
		</tr>
	</table>
</body>


</html>