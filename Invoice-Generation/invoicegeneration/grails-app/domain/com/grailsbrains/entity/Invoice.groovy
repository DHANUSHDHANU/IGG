package com.grailsbrains.entity

class Invoice {

    String title
    int referenceNumber
    String poNumber
    String dueDate
    String invoiceDate
    String description
    String notes
    String footer
    Vendor vendor


    static hasOne = [client:Client]
    static hasMany = [items:Item]



    static constraints = {
        dueDate(nullable: true)
        invoiceDate(nullable: true)
        description(nullable: true)
        notes(nullable: true)
        referenceNumber(unique: true)
        footer(nullable: true)
    }

}
