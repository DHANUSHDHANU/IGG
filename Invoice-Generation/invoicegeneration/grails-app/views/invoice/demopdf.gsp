
<p>Invoice created</p>
<g:form>
<g:each in="${invoices}" status="i" var="invoiceInstance">

    ${fieldValue(bean: invoiceInstance,field: "client") }




</g:each>
    <g:link controller="invoice" action="aftersave" > <a href=" ${request.requestURI}.pdf" >Generate Pdf</a></g:link>



</g:form>
