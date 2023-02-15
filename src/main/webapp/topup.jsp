<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Merchant2U - Online Mobile Top Up!</title>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<!--Bootsrap 4 CDN-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!--Fontawesome CDN-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<!--Custom styles-->

</head>
<body>
	<div id="">
		<h3 class="text-center pt-5">Merchant2U - Online Mobile Top Up!</h3>
		<div class="container">
			<div class="row justify-content-center align-items-center">
				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<h3 class="card-title text-info">Top Up Detail</h3>
							<form name="TopUpForm" id="TopUpForm" class="form"
								action="Payment?a=bank" method="post">
								<div class="form-group row">
									<label class="col-sm-2 col-form-label"></label>
									<div class="col-sm-10 font-weight-bold text-${color}">${notification}</div>
								</div>

								<div class="form-group row">
									<label class="col-sm-2 col-form-label">Mobile Number</label>
									<div class="col-sm-4">
										<input type="text" name="mobile_number" class="form-control"
											id="mobile_number" placeholder="Mobile Number"
											value="0123456789">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-2 col-form-label">Operator</label>
									<div class="col-sm-4">
										<input type="text" name="operator" class="form-control"
											id="operator" placeholder="Operator" value="Celcom">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-2 col-form-label">Amount (RM)</label>
									<div class="col-sm-4">
										<input type="text" name="amount" class="form-control"
											id="amount" placeholder="Operator" value="50.00">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-2 col-form-label">Bank Name</label>
									<div class="col-sm-4">
										<input type="text" name="bank_name" class="form-control"
											id="bank_name" placeholder="Bank Name" value="MyBank2U">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-2 col-form-label">Account Number</label>
									<div class="col-sm-4">
										<input type="text" name="account_number" class="form-control"
											id="account_number" placeholder=Account Number value="10042">
									</div>
								</div>
								<div class="form-group row">
									<label class="col-sm-2 col-form-label"> </label>
									<div class="col-sm-4">
										<input type="submit" name="submit"
											class="btn btn-warning btn-md" value="Pay Now">
									</div>
								</div>

							</form>
						</div>
					</div>
					<div class="col-md-12 m-3 text-right">
						<a href="Login" class="btn btn-info btn-md">Logout</a>
					</div>

				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>