<g:render template="/common/sidebar" />
<g:form controller="address" action="insert" method="post" class="form-horizontal">
    <g:hiddenField name="firstName" value="${vendor?.firstName}" />
    <g:hiddenField name="lastName" value="${vendor?.lastName}" />
    <g:hiddenField name="dob" value="${vendor?.dob}" />
    <g:hiddenField name="email" value="${vendor?.email}" />
    <g:hiddenField name="mobileNumber" value="${vendor?.mobileNumber}" />
    <g:hiddenField name="phoneNumber" value="${vendor?.phoneNumber}" />
    <g:hiddenField name="fax" value="${vendor?.fax}" />
    <g:hiddenField name="cin" value="${vendor?.cin}" />
    <g:hiddenField name="website" value="${vendor?.website}" />

    <h1 class="text-center">Address</h1>
    <br>
    <div class="form-group">
        <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="street">Street:</label>
        <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
            <input type="text" class="form-control" name="street" id="street" placeholder="Enter street">
        </div>
    </div>
    <br>
    <div class="form-group">
        <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="city">City:</label>
        <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
            <input type="text" class="form-control" name="city" id="city" placeholder="Enter City">
        </div>
    </div>
    <br>
    <div class="form-group">
        <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="pincode">Pincode:</label>
        <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
            <input type="text" class="form-control" name="pincode" id="pincode" placeholder="Enter pincode">
        </div>
    </div>
    <br>
    <div class="form-group">
        <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="state">State:</label>
        <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
            <input type="text" class="form-control" name="state" id="state" placeholder="Enter State">
        </div>
    </div>
    <br>
    <div class="form-group">
        <label class="control-label col-sm-4 col-sm-4 col-md-2 col-lg-2" for="country">Country:</label>
        <div class="col-sm-6 col-sm-6 col-md-6 col-lg-6">
            <input type="text" class="form-control" name="country" id="country" placeholder="Enter Country">
        </div>
    </div>
    <br>
    <div class="form-group">
        <div class="col-sm-offset-4 col-md-offset-2 col-lg-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </div>
</g:form>

</div>
</div>
</div>
</body>
</html>