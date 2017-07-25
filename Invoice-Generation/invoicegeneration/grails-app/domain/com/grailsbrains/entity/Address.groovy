package com.grailsbrains.entity

class Address {

    int pincode
    String landMark
    String street
    String city
    String state
    String country
    String description

    static constraints = {
        landMark(nullable:true, blank:true)
        description(nullable:true, blank:true)
        street(nullable:true, blank:true)
    }
}
