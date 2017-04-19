<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Java Coding School</title>
      <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
      
	  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	  <link rel="stylesheet" href="/resources/css/style.css">
	  <script src="/resources/js/trading.platform.v1.01.js"></script> 
	  
	  <script>
	  $(function(){
	  /*
		$( "datepicker" ).datepicker({
		changeMonth: true,
		changeYear: true 
		});
	  */
	  tradingPlatform.init();
	  tradingPlatform.login.init();
	  });
	  </script>

  
</head>

<body>
<input type="hidden" class="customClassCsrf" name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <h1>Stock Trading Project</h1>
	
    <div class="login-page">
	  <div class="form">
		<form class="register-form">
		  <input type="text" placeholder="first name"/>
		  <input type="text" placeholder="last name"/>
		  <input type="date" id="datepicker" placeholder="date of birth"/>
		  <input type="text" placeholder="mobile"/>
		  <input type="text" placeholder="name"/>
		  <input type="password" placeholder="password"/>
		  <input type="text" placeholder="email address"/>
		  <button>create</button>
		  <p class="message">Already registered? <a href="#">Sign In</a></p>
		</form>
		<form class="login-form">
		 
		  <input type="text" class="customClassLoginUsername" placeholder="username"/>
		  <input type="password" class="customClassLoginPassword" placeholder="password"/>
		  
		  <p class="customclassloginMessage small text-danger"></p>
		  
		  <button  class="customClassLoginButton">login</button>
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
		    <input type="email" pattern="[^ @]*@[^ @]*" value="">
			<br><br>
			<input type="submit" value = "Submit">
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
