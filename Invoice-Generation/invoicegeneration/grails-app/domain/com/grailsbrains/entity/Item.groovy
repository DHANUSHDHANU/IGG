package com.grailsbrains.entity

class Item {

    String itemName
    int quantity
    Double price
    Double amount
    Double subTotal
    String itemdescription
    Tax tax
    static belongsTo = Vendor

    static constraints = {
        amount(nullable:true, blank:true)
        subTotal(nullable:true, blank:false)
        itemdescription(nullable:true, blank:true)
        tax(nullable:true, blank:false)

    }
}
