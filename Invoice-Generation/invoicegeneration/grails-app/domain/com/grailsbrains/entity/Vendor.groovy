package com.grailsbrains.entity

import com.grailsbrains.auth.User

class Vendor extends ClientVendorDetail {

    String cin
    Date dob
    byte[] logo
    String website
    User user

    static hasMany = [addresses:Address, clients:Client ]


    static constraints = {
        cin(nullable:true, blank:true)
        lastName(nullable:true, blank:true)
        logo(nullable:true, maxSize:1073741824)
        website(nullable:true, blank:true)
        phoneNumber(nullable:true, blank:true)
        dob(nullable: true, blank:false)
        user(nullable: true,blank:false)
    }
    static mapping = {
        logo sqlType: "longblob"
    }
}
