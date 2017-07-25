<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <asset:stylesheet src="style.css"/>
    <link rel="stylesheet" type="text/css" href="style.css">

    <title>Homepage</title>
</head>
<body class=" bg_dash">
<div class="container-fluid">
    <div class="row.content">
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 sidenav" height="1em">
            <div>

            </div>
            <div panel-color>
                <div class="panel-group">
                    <div class="panel panel-custom">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href=""> Welcome <sec:loggedInUserInfo field='username'/></a>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-custom">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse1">DASHBOARD</a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse">
                            <ul class="list-group">
                                <g:link controller="vendor" action="info"><li class="list-group-item">Profile</li></g:link>
                                <g:link controller="address" action="add"><li class="list-group-item">Address</li></g:link>
                                <g:link  controller='logout' ><li class="list-group-item">Sign Out</li></g:link>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-custom">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse2">INVOICE</a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <ul class="list-group">
                                <g:link controller="invoice" action="showtemplate"><li class="list-group-item">New Invoice</li></g:link>
                                <g:link controller="invoice" action="invoicelist"><li class="list-group-item">Invoice List</li></g:link>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-custom">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse3">RECURRING INVOICE</a>
                            </h4>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse">
                            <ul class="list-group">
                                <g:link ><li class="list-group-item">New Invoice</li></g:link>
                                <g:link ><li class="list-group-item">Invoice List</li></g:link>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">