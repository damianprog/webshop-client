<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="eng">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/addProduct.css" type="text/css" />
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

		<h2>Add Product</h2>
		<hr />
		<form:form action="/admin/saveProduct" modelAttribute="product"
			method="POST" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="addingName">Product Photo (JPG extension, please)</td>
				</tr>
				<tr>
					<td class="bottomTd"><input type="file" name="photo"
						class="inputBox" required="required" /></td>
				</tr>


				<tr>
					<td class="addingName">Product Name</td>
				</tr>
				<tr>
					<td class="bottomTd"><form:input path="name"
							id="productNameBox" required="required" /></td>
				</tr>

				<tr>
					<td class="addingName">Brand</td>
				</tr>
				<tr>
					<td class="bottomTd"><form:input path="brand"
							id="productNameBox" required="required" /></td>
				</tr>

				<tr>
					<td class="addingName">Category</td>
				</tr>

				<tr>
					<td class="bottomTd"><form:select path="category"
							class="inputBox" required="required">
							<option value="Video Games">Video Games</option>
							<option value="Headphones">Headphones</option>
							<option value="Laptops">Laptops</option>
							<option value="Phones">Phones</option>
							<option value="Drones">Drones</option>
							<option value="TV">TV</option>
						</form:select></td>
				</tr>

				<tr>
					<td class="addingName">Price</td>
				</tr>
				<tr>
					<td class="bottomTd"><form:input path="price" class="inputBox"
							required="required" /></td>
				</tr>

				<tr>
					<td class="addingName">Highlights (Add ";" sign, after every
						highlight)</td>
				</tr>
				<tr>
					<td class="bottomTd"><form:textarea path="highlights"
							class="reviewArea" required="required"/></td>
				</tr>

				<tr>
					<td class="addingName">Description</td>
				</tr>
				<tr>
					<td class="bottomTd"><form:textarea path="description"
							class="descriptionArea" required="required" /></td>
				</tr>

			</table>
			<input id="submit" type="submit" value="Create" />
		</form:form>

	</div>
</body>

</html>