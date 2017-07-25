<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <asset:stylesheet src="style.css"/>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body style="background-color: #f0f2f2">
<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 col-sm-offset-2 col-md-offset-2 col-lg-offset-2 text-center">
        <g:img dir="images" file="" width="40" height="40"/>
        <h2>Create the Perfect Invoice to Match your Brand</h2>
        <div class="row">
            <div class="col-sm-6 col-md-6 col-lg-6">
                <g:form controller="Invoice" action="showinvoice" enctype="mulitpart/form-data">
                <div>
                    <input type="file" name="fileupload" id="fileupload" accept="image/*" multiple="multiple">
                </div>

            </div>
            <div class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-5 col-md-5 col-lg-5">
                <div>
                    <h2 style="color:#2e6da4;">Choose Your Template</h2>
                    <div id="myCarousel" class="carousel slide" data-interval="false">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner image-wrapper" >
                            <div class="item active">
                                <g:img class="carousel-image" dir="images" file="invoice1.png" align="middle" width="100%" height="100%"/>
                            </div>

                            <div class="item">
                                <g:img class="carousel-image" dir="images" file="invoice2.png" align="middle"/>
                            </div>

                            <div class="item">
                                <g:img class="carousel-image" dir="images" file="invoice-3.jpg" align="middle"/>
                            </div>
                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row div_go_pos">
            <div class="col-sm-3 col-lg-3 col-lg-6">
                <input type="submit" value="Looks Great Lets Go..."class="btn btn-primary btn-lg">
            </div>
                </g:form>
        </div>
        <br>
    </div>
</div>
</body>
</html>