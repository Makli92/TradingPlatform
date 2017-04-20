var tradingPlatform = {
		
		'constants' : {
			
			'responseStatuses' : {
					'OK' : 'OK',
					'ERROR' : 'ERROR'
				
			},
			'generalErrorMessage' : 'Παρουσιάστηκε τεχνικό σφάλμα',
			'fadeoutDelay': 5000,
			'fadeinDelay' : 'slow'
			
		},
		
		/* login js code*/
		'login' : {
			'config' : {
				
				'loginEndpoint' : '/services/auth',
				'afterSuccessfulLoginUrl' : '/dashboard'
				
			},
			'init': function() {
				
				$('.customClassLoginButton').bind( "click", function( event ) {
				    
					if($(".customClassLoginUsername").val() !== ""){
					
						tradingPlatform.login.loginAttempt();
					}

				});
				
			},
			
			'loginAttempt': function() {
				
				// Send request
				$.ajax({
					type : 'POST',
					url : tradingPlatform.login.config.loginEndpoint,
					cache : false,
					data : {
						'username' : $(".customClassLoginUsername").val(),
						'password' : $(".customClassLoginPassword").val(),
						'_csrf' : $(".customClassCsrf").val()
					}
					,
					success : function(data) {
						console.log('loginAttempt1:' + JSON.stringify(data));
						
						if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK){
							
							if(data.item.authenticationStatus == tradingPlatform.constants.responseStatuses.OK){
								
								location = tradingPlatform.login.config.afterSuccessfulLoginUrl;

							}else{
								
								tradingPlatform.login.loginMessage(data.item.authenticationStatusMessage);
								
							}
							

						}else{
							
							tradingPlatform.login.loginMessage(data.responseStatusMessage);
							
						}
						
					},
					error : function() {
					
						tradingPlatform.login.loginMessage(tradingPlatform.constants.generalErrorMessage);
						console.log ('loginAttempt1 error');	

					}
				});	
				
			} , 
			
			'loginMessage' : function(msg) {
				
				$(".customclassloginMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
				
				$('.customclassloginMessage').text(msg)
				
				$(".customclassloginMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);

			}
			
			
			
			
		},
		/* login js code*/
		'register' : {
			'config' : {
				
				'registerEndpoint' : '/services/register',
				'SuccesfullRegistrationMessage' : 'Η εγγραφή σας ολοκληρώθηκε'
				
			},
			'init': function() {
				
				$('.customClassRegisterButton').bind( "click", function( event ) {
				   
					tradingPlatform.register.registerAttempt();

				});
				
			},
			
			'registerAttempt': function() {
				
				// Send request
				$.ajax({
					type : 'POST',
					url : tradingPlatform.register.config.registerEndpoint,
					cache : false,
					data : {
						'firstname' : $(".customClassRegisterFirstname").val(),
						'lastname' : $(".customClassRegisterLastname").val(),
						'birthDate' : $(".customClassRegisterBirthDate").val(),
						'mobile' : $(".customClassRegisterMobile").val(),
						'username' : $(".customClassRegisterUsername").val(),
						'password' : $(".customClassRegisterPassword").val(),
						'passwordConfirm' : $(".customClassRegisterPasswordConfirm").val(),
						'email' : $(".customClassRegisterEmail").val(),
						'_csrf' : $(".customClassCsrf").val()
					}
					,
					success : function(data) {
						console.log('registerAttempt1:' + JSON.stringify(data));
						
						if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK){
							
							if(data.item.registrationStatus == tradingPlatform.constants.responseStatuses.OK){

								tradingPlatform.register.successfulRegistrationMessage(tradingPlatform.register.config.SuccesfullRegistrationMessage);

								$(".customClassRegisterFirstname").val('');	
								$(".customClassRegisterLastname").val('');
								$(".customClassRegisterBirthDate").val('');
								$(".customClassRegisterMobile").val('');
								$(".customClassRegisterUsername").val('');
								$(".customClassRegisterPassword").val('');
								$(".customClassRegisterPasswordConfirm").val('');
								$(".customClassRegisterEmail").val('');
	
							}else{
								
								tradingPlatform.register.registrationMessage(data.item.registrationStatusMessages);
								
							}
							

						}else{
							
							var tempArray = new Array(data.responseStatusMessage);
							
							
							tradingPlatform.register.registrationMessage(tempArray);
							
						}
						
					},
					error : function() {
						
						var tempArray = new Array(tradingPlatform.constants.generalErrorMessage);
						
						tradingPlatform.register.registrationMessage(tempArray);
						console.log ('registrationMessage1 error');	

					}
				});	
				
			} , 
			
			'registrationMessage' : function(msg) {
				
				var tempArray = new Array();
				
				if($.isArray(msg)){
					
					tempArray = msg;
					
				}else{
					
					tempArray[0] = msg;
					
				}
			
				
				$(".customclassRegisterMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
				
				$('.customclassRegisterMessage').text("");
				
				for (var i = 0; i < tempArray.length; i++) {

				    $('.customclassRegisterMessage').html(
				    		
/*
				    		
				    		$('.customclassRegisterMessage').html()
				    		+ '<div class="alert alert-danger" role="alert"><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span><span class="sr-only">Error:</span>'
				    		+ tempArray[i]
				    		+ '</div>'
	*/
				    		$('.customclassRegisterMessage').html()
				    		+ '<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span><span class="sr-only">Error:</span> '
				    		+ tempArray[i] + '<br />'
				    		
				    );
				    
				}
	
				
				$(".customclassRegisterMessage").fadeOut(tradingPlatform.constants.fadeoutDelay * 3);

			},
			
			'successfulRegistrationMessage' : function(msg) {
				
				var tempArray = new Array();
				
				if($.isArray(msg)){
					
					tempArray = msg;
					
				}else{
					
					tempArray[0] = msg;
					
				}
			
				
				$(".customclassRegisterSuccessfulMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
				
				$('.customclassRegisterSuccessfulMessage').text("");
				
				for (var i = 0; i < tempArray.length; i++) {

		    		$('.customclassRegisterSuccessfulMessage').html()
		    		+ '<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span><span class="sr-only">Success:</span> '
		    		+ tempArray[i] + '<br />'
					
					
				    $('.customclassRegisterSuccessfulMessage').text(
				    		$('.customclassRegisterSuccessfulMessage').text()
				    		+ tempArray[i]	
				    );
				    
				}
	
				
				$(".customclassRegisterSuccessfulMessage").fadeOut(tradingPlatform.constants.fadeoutDelay * 3);

			}
		},
		
		/* login js code*/
		'forgotPass' : {
			'config' : {
				
				'forgotPassEndpoint' : '/services/forgot'
				
			},
			'init': function() {
				
				$('.customClassForgotPassButton').bind( "click", function( event ) {
				    
					if($(".customClassForgotPassEmail").val() !== ""){
					
						tradingPlatform.forgotPass.forgotPassAttempt();
					}

				});
				
			},
			
			'forgotPassAttempt': function() {
				
				// Send request
				$.ajax({
					type : 'POST',
					url : tradingPlatform.forgotPass.config.forgotPassEndpoint,
					cache : false,
					data : {
						'email' : $(".customClassForgotPassEmail").val(),
						'_csrf' : $(".customClassCsrf").val()
					}
					,
					success : function(data) {
						console.log('forgotPassAttempt1:' + JSON.stringify(data));
						
						if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK){
							
							if(data.item.forgotStatus == tradingPlatform.constants.responseStatuses.OK){
								
								tradingPlatform.forgotPass.forgotPassMessage(data.item.forgotStatusMessage);
								
							}
							

						}else{
							
							tradingPlatform.forgotPass.forgotPassMessage(data.responseStatusMessage);
							
						}
						
					},
					error : function() {
					
						tradingPlatform.forgotPass.loginMessage(tradingPlatform.constants.generalErrorMessage);
						console.log ('forgotPass1 error');	

					}
				});	
				
			} , 
			
			'forgotPassMessage' : function(msg) {
				
				$(".customclassForgotPassMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
				
				$('.customclassForgotPassMessage').text(msg)
				
				$(".customclassForgotPassMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);

			}
			
		},
		
		'init': function() {

			// Prevent submitting  form
			$(document).on("submit", "form", function(e){
			    e.preventDefault();
			    return  false;
			});
			
		}
};