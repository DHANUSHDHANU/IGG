<g:render template="/common/sidebar" />
            <g:form controller="vendor" action="profile" method="post" class="form-horizontal">
                <h1 class="text-center">Personal Information</h1>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="first-name">First Name:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="firstName" id="first-name" placeholder="Enter First Name">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="last-name">Last Name:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="lastName" id="last-name" placeholder="Enter Last Name">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="dob">Date of Birth:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="dob" id="dob" placeholder="Enter Date of Birth">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="email">Email:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="email" id="email" placeholder="Enter Email">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="mobile-number">Mobile Number:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="mobileNumber" id="mobile-number" placeholder="Enter Mobile Number">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="phone-number">Phone Number:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="phoneNumber" id="phone-number" placeholder="Enter Phone Number">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="fax">Fax:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="fax" id="fax" placeholder="Enter Fax">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="cin">CIN:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="cin" id="cin" placeholder="Enter vendor CIN">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="website">Website:</label>
                    <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="website" id="website" placeholder="www.anything.com">
                    </div>
                </div>
                <br>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-md-offset-2 col-lg-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Lets Get Started</button>
                    </div>
                </div>
            </g:form>

        </div>
    </div>
</div>
</body>
</html>