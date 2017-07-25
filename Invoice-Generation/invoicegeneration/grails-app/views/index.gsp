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
    <title>GrailsBrains</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-custom navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 10px">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Grails Brains</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right" style="margin-right: 10px">
                <li><a data-toggle="modal" data-target="#login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                <li><a data-toggle="modal" data-target="#signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Contact us</a><li>
                <li><a href="#">About us</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="jumbotron" style="padding:0px;">
    <!--<img src="images/intro.png" alt="image"   width="100%"/>-->
    <div class="row main-content">
        <div class="row">
            <div class="col-md-5 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-5 col-xs-offset-1" >
                <h1 id="logo">Generate Invoice</h1>
            </div>
        </div>
    </div>
</div>

<!--Login Modal -->
<div class="modal fade" id="login" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <!--<div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div> -->
            <div class="modal-body">
                <form action="/login/authenticate" method="post" class="form-horizontal">
                    <input type='hidden' name='spring-security-redirect'
                           value='/secure' />
                    <h1 class="text-center">Login</h1>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-2 col-md-2" for="username">Username:</label>
                        <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                            <input type="text" class="form-control" name="username" id="username" placeholder="Enter username">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="password">Password:</label>
                        <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                            <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-md-10 col-lg-10 col-sm-offset-3 col-md-offset-3 col-lg-offset-3">
                            <div class="checkbox">
                                <p>Forgot Password ? <g:link>click here</g:link></p>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-md-10 col-lg-10 col-sm-offset-3 col-md-offset-3 col-lg-offset-3">
                            <button type="submit" class="btn btn-default">Login</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" data-toggle="modal" data-target="#signup">Signup</button>
            </div>
        </div>

    </div>
</div>

<!--Signup Modal -->
<div class="modal fade" id="signup" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <!--<div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>-->
            <div class="modal-body">
                <g:form controller="user" action="register" method="post" class="form-horizontal">
                    <h1 class="text-center">Signup</h1>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Username:</label>
                        <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                            <input type="email" class="form-control" name="username" id="email" placeholder="Enter email">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                            <input type="password" class="form-control" name="password" id="pwd" placeholder="Enter password">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="orgname">Orgnization Name:</label>
                        <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                            <input type="text" class="form-control" name="organizationName" id="orgname" placeholder="Organization name">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="work_area">Work Area:</label>
                        <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                            <input type="text" class="form-control" name="workingArea" id="work_area" placeholder="Working area">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-8">
                            <button type="submit" class="btn btn-default">Lets Get Started</button>
                        </div>
                    </div>
                </g:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<footer>
    <div>

    </div>
</footer>

<script>
    // Get the modal
    var modal = document.getElementById('login');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

</body>
</html>