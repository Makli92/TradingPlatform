var tradingPlatform = {
		
		'constants' : {
			
			'responseStatuses' : {
					'OK' : 'OK',
					'ERROR' : 'ERROR'
				
			},
			'generalErrorMessage' : 'Παρουσιάστηκε τεχνικό σφάλμα',
			'fadeoutDelay': 5000,
			'fadeinDelay' : 'slow',
			'SIDE' : { 'BUY' : 'BUY', 'SELL' : 'SELL'},
			'numberFormatGreek' : {format:"#.###,00", locale:"el"}
			
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
		
		'getNewOrderData' : { /* tradingPlatform.getNewOrderData - Start */
			'config' : {
				
				'loginEndpoint' : '/services/getNewOrderData',
				'loadingHTML' : ' <i class="fa fa-spinner fa-spin" style="font-size:16px"></i>'
			},
			
			'variables' : {
				
				'spinner' : null,
				'slider' : null,
				'RequestNewOrderDataTimeout' : null,
				'minValue' : 1,
				'maxValue' : 1000,
				'companyId' : 1
			}
			,
			'init': function(companyId) {
				
				tradingPlatform.getNewOrderData.variables.companyId = companyId;
				
				
				
				console.log("getNewOrderData.init start");
				
				$('.spinner input').prop("readonly", true);

				tradingPlatform.getNewOrderData.variables.slider = $( "#slider-range-min" ).slider({
				      range: "min",
				      value: 1,
				      min: 1,
				      max: 700,
				      slide: function( event, ui ) {
				      
				    	  tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
				    	  
				      	$('.spinner input').val(ui.value );
				      
				        //$( "#amount" ).val( ui.value );
				      }
				    });
				    
				    $('.spinner input').val($( "#slider-range-min" ).slider( "value" ) );
				    
				    //$( "#amount" ).val($("#slider-range-min" ).slider( "value" ) );
				
				tradingPlatform.getNewOrderData.variables.spinner = $( ".customClassPickNumberOfStocks" ).spinner();

				  $('.spinner .btn:first-of-type').on('click', function() {
				    $('.spinner input').val( parseInt($('.spinner input').val(), 10) + 1);
				    tradingPlatform.getNewOrderData.setSlider($('.spinner input').val());
				    
				    if(tradingPlatform.getNewOrderData.variables.maxValue < parseInt($('.spinner input').val())){
				    	
				    	$('.spinner input').val(tradingPlatform.getNewOrderData.variables.maxValue);
				    }
				    
				    tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
				  
				  });
				  $('.spinner .btn:last-of-type').on('click', function() {
				    $('.spinner input').val( parseInt($('.spinner input').val(), 10) - 1);
				    tradingPlatform.getNewOrderData.setSlider($('.spinner input').val());
				    
				    if(tradingPlatform.getNewOrderData.variables.minValue > parseInt($('.spinner input').val())){
				    	
				    	$('.spinner input').val(tradingPlatform.getNewOrderData.variables.minValue);
				    }
				    
				    
				    tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
				    
				  });

				  
					$('.customClassPickQuantity').bind( "input", function( event ) {
					    
						tradingPlatform.getNewOrderData.setSlider($('.spinner input').val());
						
						tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
						
					});

					$(".customClassSideOption").change(function() {
					
						$(".customClassPickQuantityPanel").show(2500);

						tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
					
						if($("input[name=customNameSIDE]:checked").val() == tradingPlatform.constants.SIDE.BUY ){
							
							if($(".customClassOrderDetailsSell").is(":visible")){
								
								$(".customClassOrderDetailsSell").hide();
								$(".customClassOrderDetailsBuy").show();
							}else{
								$(".customClassOrderDetailsSell").hide();
								$(".customClassOrderDetailsBuy").show(2500);
								
							}
							
						} else if ($("input[name=customNameSIDE]:checked").val() == tradingPlatform.constants.SIDE.SELL){
							
							if($(".customClassOrderDetailsBuy").is(":visible")){
								
								$(".customClassOrderDetailsBuy").hide()
								$(".customClassOrderDetailsSell").show();
							}else{
								
								$(".customClassOrderDetailsBuy").hide()
								$(".customClassOrderDetailsSell").show(2500);
								
							}
							
							
							$(".customClassOrderDetailsBuy").hide()
							
							$(".customClassOrderDetailsSell").show(2500);
							
						} else{
							
							$(".customClassOrderDetailsBuy").hide();
							$(".customClassOrderDetailsSell").hide();
							
						}

					});
					
					tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
				
			},
			
			'setSlider' : function(value) {
				
				tradingPlatform.getNewOrderData.variables.slider.slider( "value", parseInt(value) );
				
			},
			
			'RequestNewOrderDataRequest': function() {
				
				$(".customClassBackEndDataLoading").html(tradingPlatform.getNewOrderData.config.loadingHTML);
				
				if(tradingPlatform.getNewOrderData.variables.RequestNewOrderDataTimeout != null){
					// Prevent the previous call function set with the setTimeout() to execute:
					clearTimeout(tradingPlatform.getNewOrderData.variables.RequestNewOrderDataTimeout);
					
				}
				
				tradingPlatform.getNewOrderData.variables.RequestNewOrderDataTimeout = setTimeout(function(){
				
						// Send request
						$.ajax({
							type : 'POST',
							url : tradingPlatform.getNewOrderData.config.loginEndpoint,
							cache : false,
							data : {
								'_csrf' : $(".customClassCsrf").val(),
								'companyId' : tradingPlatform.getNewOrderData.variables.companyId,
								'requestedStocks' : $('.spinner input').val()
							}
							,
							success : function(data) {
								console.log('RequestNewOrderDataRequest:' + JSON.stringify(data));
								
								if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK){
									
									if(data.item.newOrderDataStatus == tradingPlatform.constants.responseStatuses.OK){
										
										
										$(".customClassNewOrderCompanyName").text(data.item.item.company.name);
										
										$(".customClassNewOrderBuyStockPriceWithoutTaxes").text($.formatNumber(data.item.item.oneStockPriceWithoutFeesAndTaxes, tradingPlatform.constants.numberFormatGreek) + '$');
										$(".customClassNewOrderSellStockPriceWithoutTaxes").text($.formatNumber(data.item.item.oneStockPriceWithoutFeesAndTaxes, tradingPlatform.constants.numberFormatGreek) + '$');
								
										$(".customClassRequestedStockBuyPrice").text($.formatNumber(data.item.item.requestedStockBuyPrice, tradingPlatform.constants.numberFormatGreek) + '$');
										$(".customClassRequestedStockBuyfeesAndTaxes").text($.formatNumber(data.item.item.requestedStockBuyfeesAndTaxes, tradingPlatform.constants.numberFormatGreek) + '$');
										
										$(".customClassRequestedStockSellPrice").text($.formatNumber(data.item.item.requestedStockSellPrice, tradingPlatform.constants.numberFormatGreek) + '$');
										$(".customClassRequestedStockSellfeesAndTaxes").text($.formatNumber(data.item.item.requestedStockSellfeesAndTaxes, tradingPlatform.constants.numberFormatGreek) + '$');
										
										
										tradingPlatform.getNewOrderData.variables.maxValue = data.item.item.avaiableStockForPurchase;
										$(".customClassAvaiableStockForPurchase").text(data.item.item.avaiableStockForPurchase);
										
										$(".customClassNumberOfUserPurchaseStock").text(data.item.item.numberOfUserPurchaseStock);
										
										
										
										if($("input[name=customNameSIDE]:checked").val() == tradingPlatform.constants.SIDE.BUY ){
											
											tradingPlatform.getNewOrderData.variables.slider.slider( "option", "max", data.item.item.avaiableStockForPurchase);
											
											if(parseInt($('.spinner input').val()) > data.item.item.avaiableStockForPurchase ){
												
												
												$('.spinner input').val(1);
												tradingPlatform.getNewOrderData.setSlider($('.spinner input').val());
												
											}
											
										} else if ($("input[name=customNameSIDE]:checked").val() == tradingPlatform.constants.SIDE.SELL){
											
											
											
											tradingPlatform.getNewOrderData.variables.slider.slider( "option", "max", data.item.item.numberOfUserPurchaseStock);
											
											if(parseInt($('.spinner input').val()) > data.item.item.numberOfUserPurchaseStock ){
												
												
												
												$('.spinner input').val(1);
												tradingPlatform.getNewOrderData.setSlider($('.spinner input').val());
												
											}
											
										}

										
									}else{
										
										
										// TODO do something with data.item.newOrderDataStatusMessage
										
		
									}
									
		
								}else{
									
									// TODO do something with data.item.responseStatusMessage
									
								}
								
							},
							error : function() {
							
								// TODO do something with tradingPlatform.constants.generalErrorMessage
		
								console.log ('loginAttempt1 error');	
		
							}
						});	
				 	}, 1000);
			} 
		},
		
		'buyStocks' : { /* tradingPlatform.buyStocks - Start */
			'config' : {
				
				'loginEndpoint' : '/services/buyStocks'
			},
			
			'variables' : {
				
			}
			,
			'init': function() {
				
				$(".customClassBuyButton").click(function() {
				
					tradingPlatform.buyStocks.buyStocksRequest()
					
				});
				

			},

			'buyStocksRequest': function() {
				

						// Send request
						$.ajax({
							type : 'POST',
							url : tradingPlatform.buyStocks.config.loginEndpoint,
							cache : false,
							data : {
								'_csrf' : $(".customClassCsrf").val(),
								'companyId' : tradingPlatform.getNewOrderData.variables.companyId,
								'requestedStocks' : $('.spinner input').val()
							}
							,
							success : function(data) {
								console.log('buyStocksRequest:' + JSON.stringify(data));
								
								if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK){
									
									if(data.item.buyStocksStatus == tradingPlatform.constants.responseStatuses.OK){
										
										tradingPlatform.showUserDetails.getUserData();
										tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
										
										$(".customClassBuySuccessMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
										$(".customClassBuySuccessMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);
										
										
										
									}else{
										
										tradingPlatform.showUserDetails.getUserData();
										tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
										
										$('.customClassBuyErrorMessageText').text(data.item.buyStocksStatusMessage);
										$(".customClassBuyErrorMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
										$(".customClassBuyErrorMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);
		
										tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
										
									}
									
		
								}else{
									
									tradingPlatform.showUserDetails.getUserData();
									tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
									
									$('.customClassBuyErrorMessageText').text(data.item.responseStatusMessage);
									$(".customClassBuyErrorMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
									$(".customClassBuyErrorMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);

								}
								
							},
							error : function() {
								
								tradingPlatform.showUserDetails.getUserData();
								tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
								
								$('.customClassBuyErrorMessageText').text(tradingPlatform.constants.generalErrorMessage);
								$(".customClassBuyErrorMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
								$(".customClassBuyErrorMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);

								console.log ('buyStocksRequest error');	
		
							}
						});	
			}
		
		}, /* tradingPlatform.buyStocks - End */
	
		'sellStocks' : { /* tradingPlatform.buyStocks - Start */
			'config' : {
				
				'loginEndpoint' : '/services/sellStocks'
			},
			
			'variables' : {
				
			}
			,
			'init': function() {
				
				$(".customClassSellButton").click(function() {
				
					tradingPlatform.sellStocks.sellStocksRequest()
					
				});
				

			},

			'sellStocksRequest': function() {
				

						// Send request
						$.ajax({
							type : 'POST',
							url : tradingPlatform.sellStocks.config.loginEndpoint,
							cache : false,
							data : {
								'_csrf' : $(".customClassCsrf").val(),
								'companyId' : tradingPlatform.getNewOrderData.variables.companyId,
								'requestedStocks' : $('.spinner input').val()
							}
							,
							success : function(data) {
								console.log('sellStocksRequest:' + JSON.stringify(data));
								
								if(data.responseStatus == tradingPlatform.constants.responseStatuses.OK){
									
									if(data.item.sellStocksStatus == tradingPlatform.constants.responseStatuses.OK){
										
										tradingPlatform.showUserDetails.getUserData();
										tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
										
										$(".customClassSellSuccessMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
										$(".customClassSellSuccessMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);
										
										
										
									}else{
										
										tradingPlatform.showUserDetails.getUserData();
										tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
										
										$('.customClassSellErrorMessageText').text(data.item.sellStocksStatusMessage);
										$(".customClassSellErrorMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
										$(".customClassSellErrorMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);
		
										tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
										
									}
									
		
								}else{
									
									tradingPlatform.showUserDetails.getUserData();
									tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
									
									$('.customClassSellErrorMessageText').text(data.item.responseStatusMessage);
									$(".customClassSellErrorMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
									$(".customClassSellErrorMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);

								}
								
							},
							error : function() {
								
								tradingPlatform.showUserDetails.getUserData();
								tradingPlatform.getNewOrderData.RequestNewOrderDataRequest();
								
								$('.customClassBuyErrorMessageText').text(tradingPlatform.constants.generalErrorMessage);
								$(".customClassBuyErrorMessage").fadeIn(tradingPlatform.constants.fadeinDelay);
								$(".customClassBuyErrorMessage").fadeOut(tradingPlatform.constants.fadeoutDelay);

								console.log ('sellStocksRequest error');	
		
							}
						});	
			}
		
		}, /* tradingPlatform.buyStocks - End */
		
		'init': function() { /* tradingPlatform.init - start */

			// Prevent submitting  form
			$(document).on("submit", "form", function(e){
			    e.preventDefault();
			    return  false;
			});
			
		} /* tradingPlatform.init - end */
};