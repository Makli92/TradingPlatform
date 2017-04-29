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
			
		},		/* login js code*/
		'showUserDetails' : {
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
		},
		
		/*Trade View*/
		'tradeView' : {
			'config' : {
				'tradeViewEndpoint' : '/services/trades'
			},
			'init': function() {
				$( ".datepicker" ).datepicker({
		  			changeMonth: true,
		  			changeYear: true,
		  			dateFormat: 'yy-mm-dd'
		  		});
		  		
		  		$("#dateFrom").datepicker( "setDate", new Date() );
		  		$("#dateTo").datepicker( "setDate", new Date() );

				$('#searchTradeBtn').bind( "click", function( event ) {
					tradingPlatform.tradeView.tradeViewRetrieve();
				});
				
				tradingPlatform.tradeView.tradeViewRetrieve();
			},
			
			'tradeViewRetrieve': function() {
				// Empty table contents
		        $('#tradeViewTable tbody > tr').remove();

		        var payload = tradingPlatform.tradeView.tradeViewPreparePayload();
		        
				// Send request
				$.ajax({
					type : 'GET',
					url : tradingPlatform.tradeView.config.tradeViewEndpoint,
					cache : false,
					data : payload,
					success : function(data) {
						console.log('tradesView:' + JSON.stringify(data));
						
						if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK) {
							if(data.item.tradeViewStatus == tradingPlatform.constants.responseStatuses.OK) {
								$.each(data.item.item, function(index, row) {
							        var $tr = 
							        	$('<tr>').append(
								            $('<td>').html(row.company),
								            $('<td>').html(tradingPlatform.utilities.convertDate(row.tradeDate)),
								            $('<td>').html(row.side),
								            $('<td>').html(row.quantity),
								            $('<td>').html(tradingPlatform.utilities.addDecimalDigits(row.orderPriceWithFeeTaxes)),
								            $('<td>').html(tradingPlatform.utilities.addDecimalDigits(row.unitPrice)),
								            $('<td>').html(row.status),
								            $('<td>').html("?")
								        );
							        $tr.appendTo('#tradeViewTableBody');
							    });
							}
						} else {
							tradingPlatform.tradeView.tradeViewMessage(data.responseStatusMessage);
						}
					},
					error : function() {
						tradingPlatform.tradeView.tradeViewMessage(tradingPlatform.constants.generalErrorMessage);
					}
				});
			},
			'tradeViewPreparePayload' : function() {
				// Prepare request payload
		        var payload = {'from': $("#dateFrom").val(), 'to': $("#dateTo").val()};
		        
		        if ($('#sideSelect').val() != "ALL") {
		            payload.side = $("#sideSelect").val(); 
		        }
		        
		        if ($("#stock").val() != "") {
		        	payload.company = $("#stock").val();
		        }
		        
		        return payload;
			},
			'tradeViewMessage' : function(msg) {
				$(".classErrorMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
				$('.classErrorMessage').text(msg)
				$(".classErrorMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);
			}
		},
		/*Portfolio*/
		'portfolio' : {
			'config' : {
				'portfolioEndpoint' : '/services/portfolio'
			},
			'init': function() {
				$('#searchPortfolioBtn').bind( "click", function( event ) {
					tradingPlatform.portfolio.portfolioRetrieve();
				});
				
				tradingPlatform.portfolio.portfolioRetrieve();
			},
			'portfolioRetrieve': function() {
//				// Empty table contents
//		        $('#portfolioTable tbody > tr').remove();
//
//		        var payload = tradingPlatform.portfolio.portfolioPreparePayload();
//		        
//				// Send request
//				$.ajax({
//					type : 'GET',
//					url : tradingPlatform.portfolio.config.portfolioEndpoint,
//					cache : false,
//					data : payload,
//					success : function(data) {
//						if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK) {
//							if(data.item.tradeViewStatus == tradingPlatform.constants.responseStatuses.OK) {
//								$.each(data.item.item, function(index, row) {
//							        var $tr = 
//							        	$('<tr>').append(
//								            $('<td>').html(row.company),
//								            $('<td>').html(tradingPlatform.utilities.convertDate(row.tradeDate)),
//								            $('<td>').html(row.side),
//								            $('<td>').html(row.quantity),
//								            $('<td>').html(tradingPlatform.utilities.addDecimalDigits(row.orderPriceWithFeeTaxes)),
//								            $('<td>').html(tradingPlatform.utilities.addDecimalDigits(row.unitPrice)),
//								            $('<td>').html(row.status),
//								            $('<td>').html("?")
//								        );
//							        $tr.appendTo('#tradeViewTableBody');
//							    });
//							}
//						} else {
//							tradingPlatform.tradeView.tradeViewMessage(data.responseStatusMessage);
//						}
//					},
//					error : function() {
//						tradingPlatform.tradeView.tradeViewMessage(tradingPlatform.constants.generalErrorMessage);
//					}
//				});
			},
			'portfolioPreparePayload' : function() {
				// Prepare request payload
		        var payload = {};
		        
		        if ($("#portfolioStock").val() != "") {
		        	payload.company = $("#portfolioStock").val();
		        }
		        
		        return payload;
			},
			'portfolioMessage' : function(msg) {
				$(".classErrorMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
				$('.classErrorMessage').text(msg)
				$(".classErrorMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);
			}
		},
		'init': function() {

			// Prevent submitting  form
			$(document).on("submit", "form", function(e){
			    e.preventDefault();
			    return  false;
			});
			
		},
		
		/*Utilities*/
		'utilities' : {
			'config' : {
				'dateFormat' : 'dd/MM/yyyy hh:mm',
				'digitCount' : 2
			},
			'convertDate': function(millisecs) {
				function pad(month) { return (month < 10) ? '0' + month : month; }
				var dateObj = new Date(millisecs);
				return 	[pad(dateObj.getDate()), pad(dateObj.getMonth() + 1), dateObj.getFullYear()].join('-') + " " + 
						[pad(dateObj.getHours()), pad(dateObj.getMinutes())].join(':');
			},
			'addDecimalDigits': function(price, currency = '&euro;') {
				return currency + price.toFixed(tradingPlatform.utilities.config.digitCount);
			}
		}
		
};