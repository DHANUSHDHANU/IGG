package com.grailsbrains.entity

import grails.transaction.Transactional

@Transactional
class ClientService {

    def createClientService(Client client, Address address) {
        println("inside Client service")
        /*def addresses = addresses.save()*/
        client.addToAddresses(address)
        client.validate()
        def savedClient = client.save(flush:true,failOnError:true)
        println("inside Client service"+ savedClient.addresses.landMark)
        return savedClient
    }
}
