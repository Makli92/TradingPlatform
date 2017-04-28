
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Java Coding School</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/template/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/template/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/resources/template/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/template/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<!-- jQuery -->
    <script src="/resources/template/js/jquery.js"></script>
    <script src="/resources/js/hashtable.js"></script>
 	<script src="/resources/js/jquery.numberformatter-1.2.4.jsmin.js"></script>


  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	
  	<link rel="stylesheet" href="/resources/css/customCss.css">

  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<script src="/resources/js/trading.platform.v1.01.js"></script> 

	<script type="text/javascript">
		$(document).ready(function () { //this is a closure!
		
		/* Morris Charts JavaScript */
		    $.ajax({
		  url: "/resources/template/js/plugins/morris/raphael.min.js",
		  dataType: "script",
		  success: function( data, textStatus, jqxhr ) {}
			});
		
		
			    $.ajax({
		  url: "/resources/template/js/plugins/morris/morris.min.js",
		  dataType: "script",
		  success: function( data, textStatus, jqxhr ) {}
			});
			
				
			    $.ajax({
		  url: "/resources/template/js/plugins/morris/morris-data.js",
		  dataType: "script",
		  success: function( data, textStatus, jqxhr ) {}
			});
			
			tradingPlatform.showUserDetails.init();
			tradingPlatform.autoCompleteSearch.init();
			tradingPlatform.getNewOrderData.init(${companyId!"1"});
			tradingPlatform.buyStocks.init();
			tradingPlatform.sellStocks.init();
			
				$(".customClassMarketTradeOption").bind( "click", function( event ) {
						   
						$(".customClassMarketTradeOption").prop('checked', true);
					});
					
				


		});
	
	</script>

</head>

<body>
<input type="hidden" class="customClassCsrf" name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Accenture Trader</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>Themis Apostologlou</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>Themis Apostologlou</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>Themis Apostologlou</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">Read All New Messages</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <span class="customClassLoggedInUsername"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></span><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="/logout"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="/dashboard"><i class="fa fa-fw fa-dashboard"></i> Home</a>
                    </li>
                    <li class="active">
                        <a href="/newOrder"><i class="fa fa-fw fa-shopping-cart"></i></i>New Order</a>
                    </li>
                    <li>
                        <a href="/tradesView"><i class="fa fa-fw fa-table"></i> Trades View</a>
                    </li>
                    <li>
                        <a href="/portfolio"><i class="fa fa-fw fa-edit"></i> Portfolio</a>
                    </li>
                  </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">

                        <label class="control-label" for="stockQuickSearch">Stock quick search</label>
                    
                        <div class="form-group input-group">
                               <input type="text" class="form-control customClassAutoCompleteSearchInput" placeholder="Search for a company">
                               <span class="input-group-btn"><button class="btn btn-default" type="button"><i class="fa fa-search" ></i></button></span>
                        </div>
                        <h1 class="page-header customClassNewOrderCompanyName">
                            <i class="fa fa-spinner fa-spin" style="font-size:16px"></i>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                 <i class="fa fa-fw fa-money"></i> Cash: <span class="customClassLoggedInCash"><span class="customClassLoggedInCash"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></i></span>
                            </li>

                        </ol>

                    </div>
                </div>
                <!-- /.row -->


                <!-- /.row -->

                <div class="row">

                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge customClassNewOrderBuyStockPriceWithoutTaxes customClassBackEndDataLoading"><i class="fa fa-spinner fa-spin" style="font-size:18px"></i></div>
                                        <div>Availble stocks:&nbsp;<span class="customClassAvaiableStockForPurchase"><i class="fa fa-spinner fa-spin" style="font-size:18px"></i></div>
                                    </div>
                                </div>
                            </div>

                                <div class="panel-footer">
                                                   <label>
	                                                  <span class="pull-left">Buy &nbsp;</span>
	                                                  <i class="fa fa-arrow-circle-right"></i></span>
											          <input type="radio" name="customNameSIDE" id="customIdSideOption1" class="customClassSideOption" value="BUY">
										          </label>
                                    <div class="clearfix"></div>
                                </div>

                        </div>
                    </div>
                    
               <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-money fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge customClassNewOrderSellStockPriceWithoutTaxes customClassBackEndDataLoading"><i class="fa fa-spinner fa-spin" style="font-size:18px"></i></div>
                                        <div>My Stocks:&nbsp;<span class="customClassNumberOfUserPurchaseStock"><i class="fa fa-spinner fa-spin" style="font-size:18px"></i></div>
                                    </div>
                                </div>
                            </div>

                                <div class="panel-footer">
                                                  <label>
	                                                  <span class="pull-left">Sell &nbsp;</span>
	                                                  <i class="fa fa-arrow-circle-right"></i></span>
											          <input type="radio" name="customNameSIDE" id="customIdSideOption2" class="customClassSideOption" value="SELL">
										          </label>
										          
                                    <span class="pull-right">
                                    <div class="clearfix"></div>
                                </div>

                        </div>
                    </div>
              
                    <div class="col-lg-5 text-center">
                        <ul class="list-group">
                            <li class="list-group-item active">Τύπος συναλλαγής</li>
                            <li class="list-group-item">
                            
	                           		<div class="checkbox">
				                            	<label>
												<input type="checkbox" checked="checked" class="customClassMarketTradeOption" value="">Market
												</label>
												 <label>
											   <input type="checkbox" disabled  value="">Limit
											   </label>
									</div>
								
							</li>
                            <li class="list-group-item">
	                            	<div class="checkbox">
											   <label>
											   <input type="checkbox" disabled  value="">Open
											   </label>
											   											   <label>
											   <input type="checkbox" disabled  value="">Close
											   </label>
									</div>

							</li>
                        </ul>
                    </div>
                    
                </div>
                <!-- /.row -->
				
				<div class="row">
				
                    <div class="col-lg-4 customClassPickQuantityPanel"  style="display: none;">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-crosshairs fa-fw"></i> Pick quantity of Stocks</h3>
                            </div>
                            <div class="panel-body">
                               						                                
								  <div class="input-group spinner">
								    <input type="text" class="form-control customClassPickQuantity" value="42">
								    <div class="input-group-btn-vertical">
								      <button class="btn btn-default" type="button"><i class="fa fa-caret-up"></i></button>
								      <button class="btn btn-default" type="button"><i class="fa fa-caret-down"></i></button>
								    </div>
								  </div>
								     
     
									<p>
									  <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
									</p>
									 
									<div id="slider-range-min"></div>
 
     

                            </div>
                        </div>
                    </div>
                    
                    <!-- /.col-sm-4 -->
                    <div class="col-sm-4 customClassOrderDetailsBuy" style="display: none;">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <h3 class="panel-title">Order Details</h3>
                            </div>
                            <div class="panel-body">
		                       <ul class="list-group">
		                            <li class="list-group-item list-group-item-danger ">Buy Stocks</li>
		                            <li class="list-group-item">Price:<strong><span class=" customClassRequestedStockBuyPrice customClassBackEndDataLoading"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></strong></li>
		                            <li class="list-group-item">Fees & Taxes:<span class="customClassRequestedStockBuyfeesAndTaxes customClassBackEndDataLoading"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></li>
		                        </ul>
                            </div>
                            
                           <div class="alert alert-success customClassBuySuccessMessage" style="display: none;">
			                    <strong>Συγχρητήρια,</strong> η συναλλαγή ολοκληρώθηκε.
			                </div>
                            
                            <div class="alert alert-danger customClassBuyErrorMessage" style="display: none;">
			                    <strong>Σφάλμα:</strong> <span class="customClassBuyErrorMessageText"></span>
			                </div>
                            
                            <div class="panel-body">
			                    <button type="button" class="btn btn-danger customClassBuyButton">Buy / <span class="customClassRequestedStockBuyPrice customClassBackEndDataLoading"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></button>
			                </div>
                            
                        </div>
                    </div>
                   
                   
                   <!-- /.col-sm-4 -->
                    <div class="col-sm-4 customClassOrderDetailsSell" style="display: none;">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Order Details</h3>
                            </div>
                            <div class="panel-body">
		                       <ul class="list-group">
		                            <li class="list-group-item list-group-item-info">Sell Stocks</li>
		                            <li class="list-group-item">Price:<strong><span class="customClassRequestedStockSellPrice customClassBackEndDataLoading"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></strong></li>
		                            <li class="list-group-item">Fees & Taxes:<span class="customClassRequestedStockSellfeesAndTaxes customClassBackEndDataLoading"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></li>
		                        </ul>
                            </div>
                                   
                           <div class="alert alert-success customClassSellSuccessMessage" style="display: none;">
			                    <strong>Συγχρητήρια,</strong> η συναλλαγή ολοκληρώθηκε.
			                </div>
                            
                            <div class="alert alert-danger customClassSellErrorMessage" style="display: none;">
			                    <strong>Σφάλμα:</strong> <span class="customClassSellErrorMessageText"></span>
			                </div>     
                                   
                                   
                            <div class="panel-body">
			                    <button type="button" class="btn btn-info customClassSellButton">Sell / <span class="customClassRequestedStockSellPrice customClassBackEndDataLoading"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></button>
			                </div>
                            
                        </div>
                    </div>
				
				
				</div>
				
				
				<!--  continue here -->
								

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/template/js/bootstrap.min.js"></script>


</body>

</html>
