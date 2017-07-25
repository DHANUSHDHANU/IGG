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
<div class="invoice-layout">
    <g:form name="new-invoice" url="[action:'create',controller:'Invoice']">
        <div>
            <div class="panel-group">
                <div class="panel panel-default" style="background-color: #b7bbb0">
                    <div class="panel-heading" style="background-color: #b7bbb0">
                        <h3 class="panel-title">
                            <a data-toggle="collapse" href="#head">Business Address and Contact Details, Title, Summary, and Logo
                                <span class="glyphicon glyphicon-chevron-down" style="float:right;" ></span></a>
                        </h3>
                    </div>
                    <br>
                    <div id="head" class="panel-collapse collapse">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                <div class="row">
                                    <div class="col-xs-8 col-sm-6 col-md-6 col-lg-6 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
                                        <input type="file" name="logo" id="logo" style="margin-top: 10%;">
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-sm-10 col-md-10 col-lg-10 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                            <input type="text" class="form-control" name="invoice-title" id="invoice-title" placeholder="Invoice Title" value="Invoice">
                                        </div>
                                    </div>
                                    <br><br>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-md-10 col-lg-10 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                            <input type="password" class="form-control" name="description" id="description" placeholder="Summary (e.g. project name, description of invoice)">
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row text-right">
                                    <div class="form-group">
                                        <div class="col-sm-10 col-md-10 col-lg-10 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                            <c:out>Organization Name</c:out>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-md-10 col-lg-10 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                            <c:out>Country</c:out>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-md-10 col-lg-10 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                            <g:link>Edit Your Business Address and Contact Details</g:link>
                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="invoice-content">
            <div class="row content-layout">
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div>
                        <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#addcustomer">
                            <span class="glyphicon glyphicon-plus-sign"></span> Create a new customer
                        </button>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="row text-right">
                        <div class="form-group">
                            <label class="control-label col-sm-3 col-md-3 col-lg-3 col-sm-offset-3 col-md-offset-3 col-lg-offset-3" for="invoice-number">Invoice Number:</label>
                            <div class="col-sm-5 col-md-5 col-lg-5 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                <input type="text" class="form-control" name="invoice-number" id="invoice_number">
                            </div>
                        </div>
                        <br><br>
                        <div class="form-group">
                            <label class="control-label col-sm-3 col-md-3 col-lg-3 col-sm-offset-3 col-md-offset-3 col-lg-offset-3" for="po-number">P.O./S.O Number:</label>
                            <div class="col-sm-5 col-md-5 col-lg-5 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                <input type="text" class="form-control" name="po-number" id="po_number">
                            </div>
                        </div>
                        <br><br>
                        <div class="form-group">
                            <label class="control-label col-sm-3 col-md-3 col-lg-3 col-sm-offset-3 col-md-offset-3 col-lg-offset-3" for="invoice-date">Invoice Date:</label>
                            <div class="col-sm-5 col-md-5 col-lg-5 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                <input type="date" class="form-control" name="invoice-date" id="invoice_date" placeholder="">
                            </div>
                        </div>
                        <br><br>
                        <div class="form-group">
                            <label class="control-label col-sm-3 col-md-3 col-lg-3 col-sm-offset-3 col-md-offset-3 col-lg-offset-3" for="payment-due">Payment Due:</label>
                            <div class="col-sm-5 col-md-5 col-lg-5  col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                <input type="date" class="form-control" name="payment-due" id="payment_due" placeholder="">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-sm-3 col-md-3 col-lg-3  col-sm-offset-6 col-md-offset-6 col-lg-offset-6">
                                <h5>On Reciept</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-1 col-md-1 col-lg-1"></div>
                <div class="col-sm-2 col-md-2 col-lg-2 item-edit">
                    <a data-toggle="modal" data-target="#edit-columns"><h4>Edit Columns</h4></a>
                </div>
            </div>
            <div class="row item-strip">
                <div class="" style="background-color: #4cae4c;">
                    <div class="col-sm-1 col-md-1 col-lg-1"></div>
                    <div class="col-sm-6 col-md-6 col-lg-6 item-input">
                        <h3>Items</h3>
                    </div>
                    <div class="col-sm-1 col-md-1 col-lg-1 item-text">
                        <h3>Quantity</h3>
                    </div>
                    <div class="col-sm-1 col-md-1 col-lg-1 item-text">
                        <h3>Price</h3>
                    </div>
                    <div class="col-sm-2 col-md-2 col-lg-2 item-text">
                        <h3>Amount</h3>
                    </div>

                </div>
            </div>

            <div style="background-color: #31e1ef">
                <br>
                <div class="row">
                    <div class="col-sm-1 col-md-1 col-lg-1"></div>
                    <div class="col-sm-2 col-md-2 col-lg-2 item-input">
                        <input type="text" class="form-control" name="item-name" id="item_name" placeholder="Enter Item Name">
                    </div>
                    <div class="col-sm-4 col-md-4 col-lg-4 item-input">
                        <input type="text" class="form-control" name="item-desc" id="item_desc" placeholder="Enter Item Description">
                    </div>
                    <div class="col-sm-1 col-md-1 col-lg-1 item-input">
                        <input type="text" class="form-control" name="item-quantity" id="item_quantity">
                    </div>
                    <div class="col-sm-1 col-md-1 col-lg-1 item-input">
                        <input type="text" class="form-control" name="item-price" id="item_price">
                    </div>
                    <div class="col-sm-2 col-md-2 col-lg-2">
                        <input type="text" class="form-control" name="payment-due" id="payment_due" placeholder="">
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-sm-7 col-md-7 col-lg-7"></div>
                    <div class="col-sm-3 col-md-3 col-lg-3 item-tax">
                        <a data-toggle="modal" data-target="#tax"><input type="text" class="form-control  " name="tax" id="" placeholder=""></a>
                        %{--<input type="text" class="form-control  " name="tax" id="" placeholder="">--}%
                    </div>
                </div>
                <hr>
            </div>
            <div class="row">
                <div class="col-sm-7 col-md-7 col-lg-7"></div>
                <div class="col-sm-3 col-md-3 col-lg-3 text-right" style="padding-right: 2.5%;">
                    <h4>Subtotal</h4>
                </div>
                <div class="col-sm-7 col-md-7 col-lg-7 text-right" ><label class="control-label" for="" style="margin-right: 10px">TOTAL</label></div>
                <div class="col-sm-3 col-md-3 col-lg-3" style="padding-right: 2.5%;">

                    <input type="text" class="form-control  " name="tax" id="" placeholder="">
                </div>
            </div>

            <hr>
            <div class="row">
                <div class="col-sm-5 col-md-5 col-lg-5  col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                    <label class="control-label" for="notes">NOTES</label><br>
                    <g:textArea rows="4" cols="50" class="note-text" name="notes" id="notes" placeholder="Enter notes here"></g:textArea>
                </div>
            </div>
            <br><br>
        </div>
        <br>
        <div >
            <div class="panel-group">
                <div class="panel panel-default" style="background-color: #b7bbb0">
                    <div class="panel-heading" style="background-color: #b7bbb0">
                        <h3 class="panel-title">
                            <a data-toggle="collapse" href="#foot">FOOTER<span class="glyphicon glyphicon-chevron-down" style="float:right;" ></span></a>
                        </h3>
                    </div>
                    <br>
                    <div id="foot" class="panel-collapse collapse">
                        <div class="row">
                            <div class="form-group">
                                <div class="col-sm-10 col-md-10 col-lg-10 col-sm-offset-1 col-md-offset-1 col-lg-offset-1">
                                    <g:textArea rows="6" cols="140" class="note-text" name="notes" id="notes" placeholder="Enter notes here"></g:textArea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="invoice-layout">
            <div class="col-sm-4">

            </div>
            <div class="col-lg-offset-5 col-sm-3 text-right">
                <button class="btn btn-primary btn-block btn-lg" style="margin-top: 7%;">Save and Continue</button>
            </div>
        </div>
    </g:form>
</div>
</body>
</html>