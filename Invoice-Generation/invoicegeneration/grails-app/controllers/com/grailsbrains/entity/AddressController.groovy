package com.grailsbrains.entity

import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN','ROLE_USER'])
@Transactional(readOnly = true)
class AddressController {

    def springSecurityService
    AddressService addressService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Address.list(params), model:[addressCount: Address.count()]
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def add() {
        render(view: '/vendor/address')
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def addclient() {
       // def client = new Client(params)
        redirect(controller: "invoice", action: "showinvoice" , params:[client: client])
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def insert(Vendor vendor) {
        def address = new Address(params)
        println("address is " + address.toString())
        def user = springSecurityService.currentUser
        println("user is " + user.toString() )

        addressService.createAddress(address, user, vendor)
        redirect url: '/address/add'
    }

   /* @Secured(['ROLE_ADMIN','ROLE_USER'])
    def insertAddress(Client client) {
        def address = new Address(params)
        println("address is " + address.toString())
        def savedClient = addressService.createAddress(address, client)
        redirect(controller: "address", action: "addclient" , params:[client: savedClient])
    }*/

    @Transactional
    def save(Address address) {
        if (address == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (address.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond address.errors, view:'create'
            return
        }

        address.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'address.label', default: 'Address'), address.id])
                redirect address
            }
            '*' { respond address, [status: CREATED] }
        }
    }

    def edit(Address address) {
        respond address
    }

    @Transactional
    def update(Address address) {
        if (address == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (address.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond address.errors, view:'edit'
            return
        }

        address.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'address.label', default: 'Address'), address.id])
                redirect address
            }
            '*'{ respond address, [status: OK] }
        }
    }

    @Transactional
    def delete(Address address) {

        if (address == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        address.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'address.label', default: 'Address'), address.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'address.label', default: 'Address'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
