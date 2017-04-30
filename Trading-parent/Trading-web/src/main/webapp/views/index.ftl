<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Java Coding School</title>
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
	  <link rel="stylesheet" href="/resources/css/style.css">
	  
	  <script src="/resources/js/trading.platform.v1.01.js"></script> 
	  
	  <script>
	  $(function(){
	  /*
		$( "#datepicker" ).datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'dd/mm/yyyy'
		});
	  */
	  
	  tradingPlatform.init();
	  tradingPlatform.login.init();
	  tradingPlatform.register.init();
	  tradingPlatform.forgotPass.init();
	  
	  });
	  </script>

  
</head>

<body>
<input type="hidden" class="customClassCsrf" name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <h1>Stock Trading Project</h1>
	
    <div class="login-page">
	  <div class="form">
		<form class="register-form">
		  <input type="text" class="customClassRegisterFirstname" placeholder="first name"/>
		  <input type="text" class="customClassRegisterLastname" placeholder="last name"/>
		  <input type="date" class="customClassRegisterBirthDate" id="datepicker" placeholder="date of birth"/>
		  <input type="text" class="customClassRegisterMobile" placeholder="mobile"/>
		  <input type="text" class="customClassRegisterUsername" placeholder="username" title="at least 3 characters and maximum"/>
		  <input type="password" data-toggle="tooltip" data-placement="top"  class="customClassRegisterPassword" placeholder="password" title="must contains one digit from 0-9, one lowercase characters, one uppercase characters, one special symbols in the list @#$%, at least 6 characters and maximum"/>
		  <input type="password" data-toggle="tooltip" data-placement="top"  class="customClassRegisterPasswordConfirm" placeholder="confirm password" title="must contains one digit from 0-9, one lowercase characters, one uppercase characters, one special symbols in the list @#$%, at least 6 characters and maximum"/>
		  <input type="text" class="customClassRegisterEmail" placeholder="email address"/>
		  
		  <p class="customclassRegisterMessage small text-danger"></p>
		  <p class="customclassRegisterSuccessfulMessage small bg-success"></p>
		  
		  
		  <button class="customClassRegisterButton" >create</button>
		  <p class="message">Already registered? <a href="#">Sign In</a></p>
		</form>
		<form class="login-form">
		 
		  <input type="text" class="customClassLoginUsername" placeholder="username"/>
		  <input type="password" class="customClassLoginPassword" placeholder="password"/>
		  
		  <p class="customclassloginMessage small text-danger"></p>
		  
		  <button class="customClassLoginButton">login</button>
		  <p class="message">Not registered? <a href="#">Create an account</a></p>
		  <div class="container">
			  <a href="#" data-target="#m1" data-toggle="modal">Forgot my password</a>
		  </div>
		  
		</form>
		
	  </div>
	  
    </div>
	<!-- Modal -->
	  <div class="modal fade" id="m1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		  <div class="modal-content">
			<div class="modal-header">
			  <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			  <h4 class="modal-title" id="myModalLabel">Please provide an email address to reset your password</h4>
			</div>
			<div class="modal-body">
			<form action="/action_page.php">
	        Email Address:<br>
		    <input class="customClassForgotPassEmail" type="email" pattern="[^ @]*@[^ @]*" value="">
			<p class="customclassForgotPassMessage small text-danger"></p>
			<br><br>
			<input class="customClassForgotPassButton" type="button" value = "Submit">
			<input type="reset" value="Cancel">
			</form>
			</div>
		  </div>
		</div>
	  </div>
	  <!-- Modal -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="/resources/js/index.js"></script> 

</body>
</html>
