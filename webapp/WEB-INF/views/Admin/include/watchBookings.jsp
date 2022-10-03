<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Booking & Review</a></li>
			<li class="breadcrumb-item active">Watch Bookings</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Booking List</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Sr No</th>
					<th scope="col">Name</th>
					<th scope="col">Package</th>
					<th scope="col">Pay Type</th>
					<th scope="col">Amount Paid</th>
					<th scope="col">Start& End Date</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
					int sr_no = 0;
				%>
				<c:forEach var="book" items="${sessionScope.booking}">

					<tr>
						<th scope="row">${sr_no=sr_no+1}</th>
						<td> ${book.user.name}</td>
						<td> ${book.package1.title}</td>
						<td>${book.paytype}</td>
						<td> ${book.amountPaid }</td>
						<td> ${book.startdate} to ${book.enddate}</td>
						<td> <a
									href='<spring:url value="/Admin/updateBooking?bid=${book.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="fa fa-tags"></i>
										</button></a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>

	</div>
</div>

