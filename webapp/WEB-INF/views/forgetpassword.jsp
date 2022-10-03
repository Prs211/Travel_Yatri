
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Travel Yatri</title>

<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />

<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<!-- custom css file link  -->
<link rel="stylesheet" href='<spring:url value="/style.css"/>'>


<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap')
	;

/* Reseting */
* {
	margin-top: 10px;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	background: #00E5FF;
	min-height: 100vh;
}

.wrapper {
	max-width: 850px;
	background-color: #fff;
	border-radius: 10px;
	position: relative;
	display: flex;
	margin: 150px auto;
	box-shadow: 0 8px 20px 0px #1f1f1f1a;
	overflow: hidden;
}

.wrapper .form-left {
	background: #3786bd;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
	padding: 20px 40px;
	position: relative;
	width: 100%;
	color: #fff;
}

.wrapper h2 {
	font-weight: 700;
	font-size: 25px;
	padding: 5px 0 0;
	margin-bottom: 34px;
	pointer-events: none;
}

.wrapper .form-left p {
	font-size: 0.9rem;
	font-weight: 300;
	line-height: 1.5;
	pointer-events: none;
}

.wrapper .form-left .text {
	margin: 20px 0 25px;
}

.wrapper .form-left p span {
	font-weight: 700;
}

.wrapper .form-left input {
	padding: 15px;
	background: #fff;
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px;
	width: 180px;
	border: none;
	margin: 15px 0 50px 0px;
	cursor: pointer;
	color: #333;
	font-weight: 700;
	font-size: 0.9rem;
	appearance: unset;
	outline: none;
}

.wrapper .form-left input:hover {
	background-color: #f2f2f2;
}

.wrapper .form-right {
	padding: 20px 40px;
	position: relative;
	width: 100%;
}

.wrapper .form-right h2 {
	color: #3786bd;
}

.wrapper .form-right label {
	font-weight: 600;
	font-size: 15px;
	color: #666;
	display: block;
	margin-bottom: 8px;
}

.wrapper .form-right .input-field {
	width: 100%;
	padding: 10px 15px;
	border: 1px solid #e5e5e5;
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px;
	outline: none;
	color: #333;
}

.wrapper .form-right .input-field:focus {
	border: 1px solid #31a031;
}

.wrapper .option {
	display: block;
	position: relative;
	padding-left: 30px;
	margin-bottom: 12px;
	font-size: 0.95rem;
	font-weight: 900;
	cursor: pointer;
	user-select: none
}

.wrapper .option input {
	position: absolute;
	opacity: 0;
	cursor: pointer;
	height: 0;
	width: 0
}

.wrapper .checkmark {
	position: absolute;
	top: 0;
	left: 0;
	height: 18px;
	width: 18px;
	background-color: #fff;
	border: 2px solid #ddd;
	border-radius: 2px
}

.wrapper .option:hover input ~.checkmark {
	background-color: #f1f1f1
}

.wrapper .option input:checked ~.checkmark {
	border: 2px solid #e5e5e5;
	background-color: #fff;
	transition: 300ms ease-in-out all
}

.wrapper .checkmark:after {
	content: "\2713";
	position: absolute;
	display: none;
	color: #3786bd;
	font-size: 1rem;
}

.wrapper .option input:checked ~.checkmark:after {
	display: block
}

.wrapper .option .checkmark:after {
	left: 2px;
	top: -4px;
	width: 5px;
	height: 10px
}

.wrapper .register {
	padding: 12px;
	background: #3786bd;
	border-top-left-radius: 5px;
	border-bottom-right-radius: 5px;
	width: 130px;
	border: none;
	margin: 6px 0 50px 0px;
	cursor: pointer;
	color: #fff;
	font-weight: 700;
	font-size: 15px;
}

.wrapper .register:hover {
	background-color: #3785bde0;
}

.wrapper a {
	text-decoration: none;
}

@media ( max-width : 860.5px) {
	.wrapper {
		margin: 50px 5px;
	}
}

@media ( max-width : 767.5px) {
	.wrapper {
		flex-direction: column;
		margin: 30px 20px;
	}
	.wrapper .form-left {
		border-bottom-left-radius: 0px;
	}
}

@media ( max-width : 575px) {
	.wrapper {
		margin: 30px 15px;
	}
	.wrapper .form-left {
		padding: 25px;
	}
	.wrapper .form-right {
		padding: 25px;
	}
}
</style>

</head>
<body>

	<!-- header section starts  -->

	<header>

		<div id="menu-bar" class="fas fa-bars"></div>

		<a href="#" class="logo"><span>T</span>RAVEL<span>Y</span>ATREE</a>

		<nav class="navbar">
			<a href='<spring:url value="/"/>'>home</a> <a href="#book">book</a> <a href="#packages">packages</a>
			<a href="#services">services</a> <a href="#gallery">gallery</a> <a
				href="#review">review</a> <a href="#contact">contact</a>
		</nav>

		<div class="icons">
			<i class="fas fa-search" id="search-btn"></i> <i class="fas fa-user"
				id="login-btn"></i>
		</div>

		<form action="" class="search-bar-container">
			<input type="search" id="search-bar" placeholder="search here...">
			<label for="search-bar" class="fas fa-search"></label>
		</form>

	</header>
	<div class="login-form-container">

		<i class="fas fa-times" id="form-close"></i>

		<form action='<spring:url value="/login"/>' method="post">
			<h2 style="color: red">${requestScope.message}</h2>
			<h3>login</h3>
			<input type="email" name="email" class="box"
				placeholder="enter your email"> <input type="password"
				name="password" class="box" placeholder="enter your password">
			<button class="btn">login now</button>
			<input type="checkbox" id="remember"> <label for="remember">remember
				me</label>
			<p>
				forget password? <a href="#">click here</a>
			</p>
			<p>
				don't have and account? <a href='<spring:url value="/signup"/>'>register now</a>
			</p>
		</form>

	</div>
		
	<div class="wrapper">
		
		<form class="form-right" action='<spring:url value="/forgetpassword"/>' method="post">
			<h2 class="text-uppercase">Forget Password</h2>
			<h2 style="color: red">${requestScope.message}</h2>
			<div class="row">
				
			<div class="mb-3">
				<label>Your Email</label> <input type="email" class="input-field" value="${sessionScope.email}"
					name="email" required>
					
			</div>
			<button class="btn btn-primary">Get OTP</button>
			</form>
			<form action='<spring:url value="/otpverify"/>' method="post">
				<div class="col-sm-6 mb-3">
					<label>otp</label> <input type="text" name="otp"
						id="otp" class="input-field" required>
				</div>
				<button class="btn btn-primary">Confirm OTP</button>
			</div>
			
			
		</form>
	</div>
	



	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

	<!-- custom js file link  -->
	<script src="script.js"></script>

</body>
</html>