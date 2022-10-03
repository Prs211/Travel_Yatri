<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Layout</a></li>
			<li class="breadcrumb-item">Bookings</li>
			<li class="breadcrumb-item active">Update Booking</li>
			<li class="breadcrumb-item"><a class="btn btn-primary right"
				href='<spring:url value="/Admin/Dashboard"/>'>Back</a></li>
		</ol>
		<div class="alert alert-primary text-center" role="alert">
			<h2>Update Booking</h2>
		</div>

		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<div class="container mt-3">
			<div class="container" style="margin-top: 50px;">
				<form method="post"
					action='<spring:url value="/Admin/updateBooking"/>'
					enctype="multipart/form-data">
					<div class="row form-group">
						<div class="col-md-4">
							<label class="col control-label text-center" for="vehical_no">
								Start Date </label> <input type="text" name="bid"
								value="${sessionScope.booking.id}" hidden>
							<div class="input-group">
								<i class="glyphicon glyphicon-user"></i> <input name="startdate"
									class="form-control text-center"
									value="${sessionScope.booking.startdate}" type="text" />
							</div>
						</div>
						<div class="col-lg-4">
							<label class="col control-label text-center" for="vehical_type">
								End Date</label>
							<div class="input-group">
								<input name="enddate" value="${sessionScope.booking.enddate}"
									class="form-control text-center" type="text">
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

		</div>
	</div>