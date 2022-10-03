

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.fun{
background-color: aqua;
font-size: 14px;
font-style: bold;

}
</style>
<div class="content-wrapper">

	<div class="container-fluid">
		<div class="alert alert-primary text-center" role="alert">
			<h1>User Profile</h1>
		</div>

		<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.message}</h3>
		<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.erroor}</h3>
		<div class="row">



			<div class="col col-sm-12 col-lg-12">
				<section class="vh-100" style="background-color: #eee;">
					<form action='<spring:url value="/User/contactus"/>' method="post">
						<div class="container">
							<div class="col">
								<div class="card text-black" style="border-radius: 25px;">
									<div class="card-body p-md-5">
										<div class="row justify-content-center">
											<div class="col-md-10 col-lg-12">
												<div class="row jumbotron">
			
				
			
				
				
				<div class="col-sm-6 form-group">
					<label for="name-f">User Full Name</label> <input type="text"
						class="form-control" name="name" id="name" value="${sessionScope.userDetails.name}"
						placeholder="Enter your full name" oninput="allow_alphabets(this)"
						required>
					<p>${requestScope.nameerror}</p>
				</div>
				<script>
					function allow_alphabets(element) {
						let textInput = element.value;
						textInput = textInput.replace(/[^A-Za-z ]*$/gm, "");
						element.value = textInput;
					}
				</script>

				<div class="col-sm-6 form-group">
					<label for="email">Email</label> <input type="email"
						class="form-control" name="email" id="email" value="${sessionScope.userDetails.email}"
						placeholder="Enter your email." required>
					<p>${requestScope.emailerror}</p>
				</div>
				
				<div class="col-sm-4 form-group">
					<label for="tel">Phone</label> <input type="tel" name="mobile"
						class="form-control" id="mobile" value="${sessionScope.userDetails.mobile}"
						placeholder="Enter Your Contact Number." required>
					<p>${requestScope.mobileerror}</p>
				</div>
				<div class="col-sm-4 form-group">
					<label for="tel">Comment</label> <textarea  name="comment"
						class="form-control"></textarea>
						
					<p>${requestScope.mobileerror}</p>
				</div>
				
				

				<div class="col-sm-12 form-group mb-0">
					<button class="btn btn-primary float-right">Submit</button>
				</div>

			</div>
					</form>
			</div>

		</div>
	</div>
</div>
</section>
</div>
</div>
