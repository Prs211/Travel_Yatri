<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Layout</a></li>
			<li class="breadcrumb-item active">Contact Us</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Contact Us List</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.success}</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Sr No</th>
					<th scope="col"> Name</th>
					<th scope="col">Mobile</th>
					<th scope="col">Email</th>
					<th scope="col">Comment</th>
				</tr>
			</thead>
			<tbody>
				<%
					int sr_no = 0;
				%>
				<c:forEach var="con" items="${sessionScope.contactus}">

					<tr>
						<th scope="row">${sr_no=sr_no+1}</th>
						<td> ${con.name}</td>
						<td> ${con.mobile}</td>
						<td>${con.email}</td>
						<td> ${con.comment }</td>
					</tr>
					</c:forEach>
			</tbody>
		</table>

	</div>
</div>

