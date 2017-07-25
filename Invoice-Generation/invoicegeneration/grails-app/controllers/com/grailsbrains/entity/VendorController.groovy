package com.grailsbrains.entity

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Secured(['ROLE_ADMIN','ROLE_USER'])
@Transactional(readOnly = true)
class VendorController {

    def springSecurityService
    VendorService vendorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Vendor.list(params), model:[vendorCount: Vendor.count()]
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def info(){
        render(view: 'personalInfo')
    }

    def profile(Vendor vendor){
        /*def user = springSecurityService.currentUser
        vendorService.createVendorInformation(vendor, user)*/
        println(params.website)
        render view:'address', model:[vendor:vendor]
    }

    def profileAddrers(Vendor vendor){

    }

    def show(Vendor vendor) {
        respond vendor
    }

    def create() {
        respond new Vendor(params)
    }

    @Transactional
    def save(Vendor vendor) {
        if (vendor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (vendor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vendor.errors, view:'create'
            return
        }

        vendor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendor.label', default: 'Vendor'), vendor.id])
                redirect vendor
            }
            '*' { respond vendor, [status: CREATED] }
        }
    }

    def edit(Vendor vendor) {
        respond vendor
    }

    @Transactional
    def update(Vendor vendor) {
        if (vendor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (vendor.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vendor.errors, view:'edit'
            return
        }

        vendor.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendor.label', default: 'Vendor'), vendor.id])
                redirect vendor
            }
            '*'{ respond vendor, [status: OK] }
        }
    }

    @Transactional
    def delete(Vendor vendor) {

        if (vendor == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        vendor.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendor.label', default: 'Vendor'), vendor.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendor.label', default: 'Vendor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
