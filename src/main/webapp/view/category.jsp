<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/category.css" type="text/css" />
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

		<div id="header">Category: ${category}</div>
		<div id="pageInfoHeader">Page: ${currentPage}</div>

		<div style="clear: both"></div>

		<c:forEach var="tempProduct" items="${products}">

			<c:url var="productPage" value="/main/showProduct">
				<c:param name="productId">${tempProduct.id}</c:param>
			</c:url>

			<div id="productTile">

				<div id="productPhoto">
					<a href="${productPage}"> <img
						src="data:img/jpeg;base64,${tempProduct.encodedProductPhoto}">
					</a>

				</div>
				<div id="productName">
					<a href="${productPage}">
						${fn:substring(tempProduct.name,0,45)} <c:if
							test="${fn:length(tempProduct.name) > 45}">
						...
						</c:if>
					</a>
				</div>
				<br>
				<div id="sellerInfo">
					<div id="boldGrey">Sold By:</div>
					<div id="thinGrey">Shop-Electronics</div>
				</div>
				<div style="clear: both"></div>
				<br> <span id="price">&dollar; ${tempProduct.price}</span>
			</div>
		</c:forEach>

		<div style="clear: both"></div>

		<c:forEach begin="1" end="${productsPage.totalPages}" var="i">
			<c:url var="page" value="/main/showCategory">
				<c:param name="page" value="${i}"></c:param>
				<c:param name="category" value="${category}"></c:param>
			</c:url>
			<h3 id="pageNum">
				<a href="${page}">${i}</a>
			</h3>
		</c:forEach>

	</div>
</body>

</html>