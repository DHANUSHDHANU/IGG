package com.grailsbrains.entity

class Tax {

    String taxName
    Double taxRate
    String taxId


    static constraints = {
        taxName(nullable:true, blank:true)
        taxRate(nullable:true, blank:true)

    }

    }
