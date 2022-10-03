 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


		<div class="app-main">
			<div class="app-sidebar sidebar-shadow">
				<div class="app-header__logo">
					<div class="logo-src"></div>
					<div class="header__pane ml-auto">
						<div>
							<button type="button"
								class="hamburger close-sidebar-btn hamburger--elastic"
								data-class="closed-sidebar">
								<span class="hamburger-box"> <span
									class="hamburger-inner"></span>
								</span>
							</button>
							
						</div>
					</div>
				</div>
				
				<div class="scrollbar-sidebar">
					<div class="app-sidebar__inner">
						<ul class="vertical-nav-menu">
							<li class="app-sidebar__heading">Dashboards</li>
							<li><a href='<spring:url value="/User/myprofile"/>' class="mm-active"> <i class="fa fa-television" style="font-size:20px;color:red"></i> HOME
							</a></li>
							<li class="app-sidebar__heading">Travel Yatri</li>
							<li><a > <i class="fa fa-sort-amount-desc"></i>
									Menu <i class="fa fa-sort-amount-asc"></i>
							</a>
								<ul>
								<li><a href='<spring:url value="/"/>'> <i
											class="metismenu-icon"></i>Back TO Home
									</a></li>
									<li><a href='<spring:url value="/User/mybookings"/>'> <i
											class="metismenu-icon"></i> My Bookings
									</a></li>
									<li><a href='<spring:url value="/User/changepassword"/>'> <i
											class="metismenu-icon"></i> Change Password
									</a></li>
									<li><a href='<spring:url value="/User/contactus"/>'> <i
											class="metismenu-icon"> </i> Contact Us
									</a></li>
									<li><a href='<spring:url value="/User/feedback"/>'> <i
											class="metismenu-icon"> </i> Feedback
									</a></li>
									
									
									
								</ul></li>
							
					</div>
				</div>
			</div>

