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
							<h3 class="card-title text-warning">MyBank2u Banking System</h3>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Payment Status</label>
								<div class="col-sm-10 font-weight-bold text-${color}">${notification}</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Mobile Number</label>
								<div class="col-sm-10">${order.mobile_number}</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Operator</label>
								<div class="col-sm-10">${order.operator}</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Top Up Pin</label>
								<div class="col-sm-10 font-weight-bold">${pin}</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Amount (RM)</label>
								<div class="col-sm-10">${order.amount}</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Account Number</label>
								<div class="col-sm-10">${order.account_number}</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Account Balance</label>
								<div class="col-sm-10">RM ${balance}</div>
							</div>
						</div>
					</div>
					<div class="col-md-12 m-3 text-right">
						<a href="TopUp" class="btn btn-info btn-md">Back to Order</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script>
		var timer2 = "5:01";
		var interval = setInterval(function() {

			var timer = timer2.split(':');
			var minutes = parseInt(timer[0], 10);
			var seconds = parseInt(timer[1], 10);
			--seconds;
			minutes = (seconds < 0) ? --minutes : minutes;
			if (minutes < 0)
				clearInterval(interval);
			seconds = (seconds < 0) ? 59 : seconds;
			seconds = (seconds < 10) ? '0' + seconds : seconds;
			$('.countdown').html(minutes + ':' + seconds);
			timer2 = minutes + ':' + seconds;
		}, 1000);
	</script>
</body>
</html>