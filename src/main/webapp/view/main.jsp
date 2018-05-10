<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css" type="text/css" />
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

	<div id="container">

		<jsp:include page='/view/header.jsp' />

		<c:url var="videoGames" value="/main/showCategory">
			<c:param name="category">Video Games</c:param>
		</c:url>
		
		<c:url var="headphones" value="/main/showCategory">
			<c:param name="category">Headphones</c:param>
		</c:url>
		
		<c:url var="laptops" value="/main/showCategory">
			<c:param name="category">Laptops</c:param>
		</c:url>
		
		<c:url var="phones" value="/main/showCategory">
			<c:param name="category">Phones</c:param>
		</c:url>
		
		<c:url var="drones" value="/main/showCategory">
			<c:param name="category">Drones</c:param>
		</c:url>
		
		<c:url var="tvs" value="/main/showCategory">
			<c:param name="category">TV</c:param>
		</c:url>

		<div id="content">

			<div id="mainPhoto">
				<img src="/css/img/topMainPhoto.png">

				<div id="whiteBoxMainPhoto">
					<div id="mainPhotoDesc">True 4K Gaming</div>
					<div id="mainPhotoGreyDesc">Unlock the ultimate gaming
						experience.</div>
					<div id="mainPhotoCategoryLink">
						<a href="${videoGames}">Category Video Games <img
							style="vertical-align: middle;" src="/css/img/next.png">
						</a>
					</div>
				</div>
			</div>

			<div id="categoriesTiles">

				<div id="categoriesTilesHeader">Shop By Category</div>

				<table id="categoriesTilesTable">
					<tr>
					
						<td>
						<a href="${videoGames}">
						<img src="/css/img/xbox-one.png">
							<br>
							Video Games
							</a>
						</td>
						<td>
						<a href="${headphones}">
						<img src="/css/img/jblHeadphones.png">
							<br>
							Headphones
						</a>
						</td>
						<td>
						<a href="${laptops}">
						<img src="/css/img/laptop.png">
							<br>
							Laptops
						</a>
						</td>
					</tr>
					
					<tr>
						<td>
						<a href="${phones}">
						<img src="/css/img/phones.png">
							<br>
							Phones
						</a>
						</td>
						<td>
						<a href="${drones}">
						<img src="/css/img/drones.png">
							<br>
							Drones
						</a>
						</td>
						<td>
						<a href="${tvs}">
						<img src="/css/img/tvs.png">
							<br>
							TV's
						</a>
						</td>
					</tr>
				</table>

			</div>

		</div>

	</div>
</body>

</html>