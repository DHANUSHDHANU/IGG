package com.grailsbrains.entity

import com.grailsbrains.auth.User
import grails.transaction.Transactional

@Transactional
class VendorService {
    def createVendorInformation(Vendor vendor, User user) {
        if (vendor == null){
            println("Vendor Service " + vendor.toString())
        }

        else{
            vendor.setUser(user)
            vendor.save()
        }
        println("vendor after save " + vendor.toString())
    }
}
