<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Layout</a></li>
			<li class="breadcrumb-item active">Add Images</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Add Images Information</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post" action='<spring:url value="/Admin/addImage"/>' enctype="multipart/form-data">
					<div class="row form-group">
						
						<div class="col-lg-4">
							<label class="col control-label text-center" for="vehical_type">
								Description </label>
							<div class="input-group">
								<textarea name="description" class="form-control text-center"
									type="text"></textarea>
							</div>
						</div>


						<div class="col-lg-4">
							<label class="col control-label text-center" for="vehical_image">
								Image </label>
							<div class="input-group">
								<input type="file" class="form-control" id="image"
									name="image" />
							</div>
						</div>
					</div>
			</div>
			<hr>
			<div class="form-group row">
				<div class="col-md-12 text-center">
					<Button class="btn btn-large btn-success">Save</Button>
				</div>
			</div>
			</form>
		</div>
<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Sr No</th>
					<th scope="col"> Image</th>
					<th scope="col">Description</th>
					
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
					int sr_no = 0;
				%>
				<c:forEach var="img" items="${sessionScope.imageList}">

					<tr>
						<th scope="row">${sr_no=sr_no+1}</th>
						<td><img src="data:image/jpeg;base64,${img.imgUtility}" height=100px width=100px/></td>
						<td>${img.description}</td>
						<td> <a
									href='<spring:url value="/Admin/image_delete?pid=${img.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="far fa-trash-alt"></i>
										</button></a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>

	</div>
</div>

