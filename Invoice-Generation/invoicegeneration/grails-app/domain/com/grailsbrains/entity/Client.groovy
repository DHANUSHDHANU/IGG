package com.grailsbrains.entity

class Client extends ClientVendorDetail {

    String organizationName
    String website
    String currency


    static hasMany = [addresses:Address , invoices:Invoice]

    static constraints = {
        lastName(nullable:true, blank:true)
        website(nullable:true, blank:true)
        currency(nullable:true, blank:true)

        phoneNumber(nullable:true, blank:true)
    }
}
