package com.grailsbrains.entity

import com.grailsbrains.auth.User

class ClientVendorDetail {
    String firstName
    String lastName
    String email
    String phoneNumber
    String mobileNumber
    Integer fax


    static mapping = {
        tablePerHierarchy false
    }
}
