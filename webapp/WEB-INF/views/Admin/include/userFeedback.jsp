<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Booking & Reviews</a></li>
			<li class="breadcrumb-item active">View Feedback</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>User Feedback List</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.success}</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Sr No</th>
					<th scope="col"> Image</th>
					<th scope="col">Name</th>
					<th scope="col">Feedback</th>
					<th scope="col">Rating</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
					int sr_no = 0;
				%>
				<c:forEach var="feed" items="${sessionScope.feedback}">

					<tr>
						<th scope="row">${sr_no=sr_no+1}</th>
						<td><img src="data:image/jpeg;base64,${feed.imgUtility}" height=100px width=100px/></td>
						<td>${feed.name}</td>
						<td>${feed.feedback}</td>
						<td>${feed.rating}</td>
						<td> <a
									href='<spring:url value="/Admin/feedback_delete?pid=${feed.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="far fa-trash-alt"></i>
										</button></a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>

	</div>
</div>

