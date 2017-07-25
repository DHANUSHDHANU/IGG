package com.grailsbrains.entity

import com.grailsbrains.auth.User
import grails.transaction.Transactional

@Transactional
class AddressService {

    def createAddress(Address address, User user, Vendor vendor) {
        if (vendor == null){
        println("Service " + address.toString())
        }
        else{

           // address.save()
            println( 'first name is ' + vendor.firstName)
        }

        println('user is ' + user.toString())
        vendor.setUser(user)
        vendor.addToAddresses(address)
        /*client.addToAddresses(address)*/
        vendor.validate()
        vendor.save(flush:true,failOnError:true)
        /*client.save(flush:true,failOnError:true)*/
        println(" after save " + vendor.toString())
    }

    /* def createClientAddress(Address address, Client client){
        if (client == null){
            println("Service " + address.toString())
        }
        else{
            println( 'Client first name is ' + client.firstName)
        }
        client.addToAddresses(address)
        client.validate()
        def x = client.save(flush:true,failOnError:true)
        println("client after save " + client.toString())
        return x
    }*/
}
