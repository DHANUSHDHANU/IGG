package com.grailsbrains.entity

import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
@Secured(['ROLE_ADMIN','ROLE_USER'])
@Transactional(readOnly = true)
class ClientController {

    def springSecurityService
    ClientService clientService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def clients=Client.list(params)
        for(def client:clients){
        }
        respond Client.list(params), model:[clientCount: Client.count()]
    }
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def createClient(Client client){
        if(params.clientx!=null){
            def client1 = params.clientx
            println"lllllllllllllllllllll"+client1
            def cle= Client.findByOrganizationName(client1)
            println "wwwwwwwwwwwwwww " +cle
            render view: "_templeteids", model: [client:cle ]
        }
        else {


            println("ajjjjjjjjjjjjjjjjjjjjjjj" + params)
            def address = new Address(params)
            def user = springSecurityService.currentUser
            def vendor = Vendor.findByUser(user)
            //[client: Client.findByOrganizationName(params)]
            def savedClient = clientService.createClientService(client, address)
            print "cllllllllllllleeeeeeeeeeiiiiiiiiiiiidddddddd" + client.id + "===========" + client.id



            vendor.addToClients(savedClient)
            vendor.validate()
            vendor.save(flush: true, failOnError: true)
            println "pppppppppppppp" + vendor.logo
            println "::::::::::::::::::::" + savedClient.addresses

            render view: "_templeteids", model: [client: savedClient]
        }
    }
    def show(Client client) {
        respond client
    }

    def create() {
        respond new Client(params)
    }

    @Transactional
    def save(Client client) {
        if (client == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (client.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond client.errors, view:'create'
            return
        }

        client.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'client.label', default: 'Client'), client.id])
                redirect client
            }
            '*' { respond client, [status: CREATED] }
        }
    }

    def edit(Client client) {
        respond client
    }

    @Transactional
    def update(Client client) {
        if (client == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (client.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond client.errors, view:'edit'
            return
        }

        client.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'client.label', default: 'Client'), client.id])
                redirect client
            }
            '*'{ respond client, [status: OK] }
        }
    }

    @Transactional
    def delete(Client client) {

        if (client == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        client.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'client.label', default: 'Client'), client.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'client.label', default: 'Client'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
