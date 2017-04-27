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
		
		'login' : { /* tradingPlatform.login - Start */
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
			
			
			
			
		}, /* tradingPlatform.login - End */
		'register' : { /* tradingPlatform.register - Start */
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
		}, /* tradingPlatform.register - End */
		
		'forgotPass' : { /* tradingPlatform.forgotPass - Start */
			'config' : {
				
				'forgotPassEndpoint' : '/services/forgot'
				
			},
			'init': function() { /* tradingPlatform.forgotPass.init - Start */
				
				$('.customClassForgotPassButton').bind( "click", function( event ) {
				    
					if($(".customClassForgotPassEmail").val() !== ""){
					
						tradingPlatform.forgotPass.forgotPassAttempt();
					}

				});
				
			}, /* tradingPlatform.forgotPass.init - End */
			
			'forgotPassAttempt': function() { /* tradingPlatform.forgotPass.forgotPassAttempt - Start */
				
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
				
			} /* tradingPlatform.forgotPass.forgotPassAttempt - End */
			, 
			
			'forgotPassMessage' : function(msg) { /* tradingPlatform.forgotPass.forgotPassMessage - Start */
				
				$(".customclassForgotPassMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
				
				$('.customclassForgotPassMessage').text(msg)
				
				$(".customclassForgotPassMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);

			} /* tradingPlatform.forgotPass.forgotPassMessage - End */
			
		}, /* tradingPlatform.forgotPass - End */
		
		'showUserDetails' : { /* tradingPlatform.showUserDetails.init - Start */
			'config' : {
				
				'loginEndpoint' : '/services/getUserData'
				
			},
			'init': function() {
				
				tradingPlatform.showUserDetails.getUserData();
				
			},
			
			'getUserData': function() {
				
				// Send request
				$.ajax({
					type : 'GET',
					url : tradingPlatform.showUserDetails.config.loginEndpoint,
					cache : false,
					data : {
						//'_csrf' : $(".customClassCsrf").val()
					}
					,
					success : function(data) {
						console.log('getUserData:' + JSON.stringify(data));
						
						if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK){
							
							if(data.item.userDataStatus == tradingPlatform.constants.responseStatuses.OK){
								
								
								setTimeout( function() {
									
									$('.customClassLoggedInUsername').text(data.item.item.username);
									
									$('.customClassLoggedInCash').html(data.item.item.cashBalance + '&euro;');
									
								}, 1000 );
								

								
								
								//
								
							}else{
								
								//do something with  data.item.userDataStatusMessage
							}
							

						}else{
							
							//do something with data.responseStatusMessage

							
						}
						
					},
					error : function() {
					
						//do something general e.g. tradingPlatform.constants.generalErrorMessage

					}
				});	
				
			}
		}, /* tradingPlatform.showUserDetails.init - end */
		
		'autoCompleteSearch' : { /* tradingPlatform.autoCompleteSearch - start */
			'config' : {
				
				'loginEndpoint' : '/services/getCompanies'
				
			},
			'init': function() { /* tradingPlatform.autoCompleteSearch.init - start */
								
				console.log('init autoCompleteSearch:');

				// Send request
				$.ajax({
					type : 'GET',
					url : tradingPlatform.autoCompleteSearch.config.loginEndpoint,
					cache : false,
					data : {
						//'_csrf' : $(".customClassCsrf").val()
					}
					,
					success : function(data) {
						console.log('autoCompleteSearch:' + JSON.stringify(data));

						
						if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK){
							
							if(data.item.companiesStatus == tradingPlatform.constants.responseStatuses.OK){
								
								
						    	if($.isArray(data.item.item) && data.item.item.length > 0){
						    		
						    		var results = [];
						    		
						    		for (var i = 0; i < data.item.item.length; i++) {
						    			
						    			results.push({ label: data.item.item[i].name, value: data.item.item[i].id });
						 
						    		    //alert("loop:"+ JSON.stringify(data.item.item[i]));
						    		    

						    		}
						    		
						    		
						    	}
											
								$(".customClassAutoCompleteSearchInput").autocomplete({
								    source: results,

								    select: function (e, ui) {

					
								    	/*
								    	 * Object of the following type
								    	 * { label: name, value: id }
								    	 * 
								    	 */
								    	
								    	//alert("selected!:"+ JSON.stringify(ui));
								    	
								        event.preventDefault();
								        $(".customClassAutoCompleteSearchInput").val(ui.item.label);
								    	
								    	
								    	location = "/newOrder/"+ ui.item.value + "/" + ui.item.label;
								    	
								        //alert("selected!:"+ JSON.stringify(ui));
								    	return false;
								    },

								    change: function (e, ui) {

								        alert("changed!");
								    },
								    focus: function() {
								        // prevent value inserted on focus
								    	
								        return false;
								    },
								});
								
								
							}else{
								
								//do something with  data.item.companiesStatusMessage
							}
							

						}else{
							
							//do something with data.companiesStatusMessage

							
						}
						
					},
					error : function() {
					
						//do something general e.g. tradingPlatform.constants.generalErrorMessage

					}
				});	
				
			} /* tradingPlatform.autoCompleteSearch.init - end */
			
		}, /* tradingPlatform.autoCompleteSearch - end */
		
		'init': function() { /* tradingPlatform.init - start */

			// Prevent submitting  form
			$(document).on("submit", "form", function(e){
			    e.preventDefault();
			    return  false;
			});
			
		} /* tradingPlatform.init - end */
};