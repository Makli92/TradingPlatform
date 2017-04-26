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
                                        <h5 class="media-heading"><strong><span class="customClassLoggedInUsername"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></span></strong>
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
                                        <h5 class="media-heading"><strong><span class="customClassLoggedInUsername"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></span></strong>
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
                                        <h5 class="media-heading"><strong><span class="customClassLoggedInUsername"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></span></strong>
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
                    <li>
                        <a href="/newOrder"><i class="fa fa-fw fa-shopping-cart"></i>New Order</a>
                    </li>
                    <li>
                        <a href="/tradesView"><i class="fa fa-fw fa-table"></i>Trades View</a>
                    </li>
                    <li class="active">
                        <a href="/portfolio"><i class="fa fa-fw fa-edit"></i>Portfolio</a>
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
                        <h1 class="page-header">
                            Portfolio
                        </h1>
                        <ol class="breadcrumb">

                            <li class="active">
                                <i class="fa fa-dashboard"></i> Cash: <span class="customClassLoggedInCash"><span class="customClassLoggedInCash"><i class="fa fa-spinner fa-spin" style="font-size:16px"></i></i></span>
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">


                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Stock</th>
                                        <th>Date Time</th>
                                        <th>Side</th>
                                        <th>Quantity</th>
                                        <th>Order Price</th>
                                        <th>Unit Price</th>
                                        <th>Status</th>
                                        <th>Order Details</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Accenture</td>
                                        <td>23/04/2017 19:30 PM</td>
                                        <td>Buy</td>
                                        <td>220</td>
                                        <td>€220,0</td>
                                        <td>2,2€</td>
                                        <td>Completed</td>
                                        <td> - </td>

                                    </tr>
                                    <tr>

                                    </tr>
                                    <tr>

                                    </tr>
                                    <tr>

                                    </tr>
                                    <tr>

                                    </tr>
                                    <tr>

                                    </tr>
                                    <tr>

                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

                <!-- /.row -->



                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <script src="/resources/template/js/bootstrap.min.js"></script>

</body>

</html>
