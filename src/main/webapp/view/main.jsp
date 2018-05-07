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
		
		<div id="menu">


			<h2>Menu</h2>
			<ul>
				<li><span><a id="link" href="/view/created.jsp">Main</a></span></li>
				<li><span><a id="link" href="/login">About
							Shop</a></span></li>
				<li><span><a id="link" href="${contactLink}">Contact</a></span></li>
			</ul>

			<c:url var="headphones" value="showProduct">
				<c:param name="productName">Beats EP On-Ear Headphones</c:param>
			</c:url>

			<h2>Categories</h2>
			<ul>
				<li id="liCategories"><span><a id="link"
						href="${headphones}">Headphones</a></span></li>
				<li id="liCategories"><span><a id="link"
						href="${videoGamesLink}">Video Games</a></span></li>
				<li id="liCategories"><span><a id="link"
						href="${printersLink}">Printers</a></span></li>
			</ul>

		</div>

		<div id="content">
			<h3>Electronics</h3>
			If you're considering a new laptop, looking for a powerful new car
			stereo or shopping for a new HDTV, we make it easy to find exactly
			what you need at a price you can afford. We offer Every Day Low
			Prices on TVs, laptops, cell phones, tablets and iPads, video games,
			desktop computers, cameras and camcorders, audio, video and more.<br /></br>
			<h3>Shop By Category</h3>
			<br />

			<table id="products">
				<tr>
					<td id="productsTd"><a id="tdLink" href="${headphonesLink}">
							<img src="/css/img/headphones.jpg" /><br /> Headphones
					</a></td>
					<td id="productsTd"><img src="/css/img/videogames.jpg" /><br />
						Video Games</td>
					<td id="productsTd"><img src="/css/img/printers.jpg" /><br />
						Printers</td>
				</tr>
			</table>

		</div>

		<div id="ad">

			<table id="adTable">

				<tr>
					<td id="firstTd"><a id="adTdLink" href="${beatsSolo3}"> <img
							src="/css/img/miniBeatsSolo3.jpg"> <br /> $156.49 <br />
							Beats Solo3 Wireless
					</a></td>
				</tr>
				<tr>
					<td id="adTd"><a id="adTdLink" href="${beatsSolo2Luxe}"> <img
							src="/css/img/miniBeatsSolo2Luxe.jpg"> <br /> $126.49 <br />
							Beats Solo 2 Luxe
					</a></td>
				</tr>
				<tr>
					<td id="adTd"><a id="adTdLink" href="${beatsEpWhite}"> <img
							src="/css/img/miniBeatsEpWhite.jpg"> <br /> $75.00 <br />
							Beats Ep White
					</a></td>
				</tr>

			</table>

		</div>

	</div>
</body>

</html>