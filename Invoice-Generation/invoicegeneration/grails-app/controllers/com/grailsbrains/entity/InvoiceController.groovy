package com.grailsbrains.entity

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import java.awt.CardLayout

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class InvoiceController {

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Invoice.list(params), model: [invoiceCount: Invoice.count()]
    }

    def displayLogo = {
        println("sl"+params.organizationName)
        def invoice = Invoice.get(params.id)
        response.contentType = "image/jpeg"
        response.contentLength = invoice?.logo.length
        response.outputStream.write(invoice?.logo)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def aftersave(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def singleInvoice = Invoice.findById(params.id)


        // def vendorList= Vendor.list().toString()
        /* for (Vendor vendor: vendorList) {
           // Byte[] logos = vendor.getLogo()*/
        def s = (singleInvoice.vendor.logo)
        println "jjjjjjjj" + s
        /*       response.contentType = "image/jpg"
            response.contentLength = s?.logo.length
            response.outputStream.write(s?.logo)
            response.outputStream.flush()*/


        // }
        def user = springSecurityService.currentUser
        def a = session.getAttribute("params")
         params.format="pdf"
        def itemList = singleInvoice.items
        println("yyyyyyyyyyyyyyyyyyyy"+itemList)
        for (Item item : itemList) {
            println("@@@@@@@@@@@@@@" + params.format)
            println("@@@@@@@@@@@@@@" + item.quantity)
        }
         /*    Invoice invoice
        println "==========================  "  + invoice.getItems()*/
            //render  view :"demopdf", model:[invoices:singleInvoice, invoiceCount: Invoice.count()]
            if (params.format == "pdf") {
                render(filename: "Invoice.pdf",
                        view: "pdfdesign",
                        model: [invoices: singleInvoice, user: user, item: itemList, invoiceCount: Invoice.count()],
                        marginLeft: 20,
                        marginTop: 20,
                        marginBottom: 25,
                        marginRight: 20,
                        headerSpacing: 15)
            }
            else
                render view: "pdfdesign",
                        model: [invoices: singleInvoice, user: user, item: itemList, invoiceCount: Invoice.count()]

    }


    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def showtemplate() {

        render view: 'template'
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def showinvoice() {
        def autogenid
        println("parrrrrrms" + params.fileupload.getBytes())
        Byte[] logo=params.fileupload.getBytes()
        // def invoice = Invoice.getId(params.id)
        //println("ttttttttttttttttttttttttt"+invoice )
        def user = springSecurityService.currentUser
        def vendor = Vendor.findByUser(user)
        println"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+Invoice.count()
        if(Invoice.findByVendor(vendor)==null)
         { autogenid="0"
        println"fffffffffffffffffff"}
            else
        {
            //autogenid=Invoice.findByClient()
            println("tttttttttttttttttttttttttttttttttttttttttttttt"+autogenid)
        }
        println("jjjjjjjjjjjjjj"+logo)
        def logo1=vendor.setLogo(logo)
        vendor.save(flush: true)
        println("vendor " + vendor)
        println("inside invoice controller " + user.organizationName)
        def clientList = Vendor.findByUser(user).clients
        render view: 'invoice', model: [user: user,  client: clientList, vendor: vendor,logo:logo1,aid:autogenid]
    }


    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def invoicecreate() {
        def user = springSecurityService.currentUser
        def vendor = Vendor.findByUser(user)
        println("paramsclienttttttttttttt" + params.oldClient)

        def taxId = params.invoiceDate
        def invoice = new Invoice(params)
        Tax tax = Tax.findByTaxName(params.taxName)
        def items = new Item(params)
        println "pppppppppppppppppppppppppppppppppppp" + params.amount
        def amt= params.amount
        Integer a=0
        for(def amt1 :amt){

            a=a+Integer.parseInt(amt1)
            //def add=am
            println("xccccccccccccccccxxxxxxxxxxxx"+a)
        }

        items.setTax(tax)
        if (params.oldClient !="Select Client") {
            def client = Client.findByOrganizationName(params.oldClient)
            println "================================" + (params.oldClient instanceof String[])
            println "iiiiiiiiiiiiiiii" + client
            invoice.setClient(client)
        }

        else{
            def client = Client.findByOrganizationName(params.organizationName)
            invoice.setClient(client)

        }

        println("organizationName" + params.oldClient)
        println"///////////////////"+(items.getClass())
        println"paramssssssitemssssss"+params
        println"ffffffffdddddddddddddddddd"+(params.itemName instanceof String)
        println"fffffff"+(params.itemName instanceof String[])
        if (params.itemName instanceof String==true) {
            println"ffffffffdddddddddddddddddd"
            def item= new Item()
           /* if(params.oldItem!=null) {
                def item1 = Item.findByItemName(params.oldItem)
                println("yeeeeeeeeeeee" + item1 + "///////////////////" + params.oldItem)
            }*/
            item.itemName= params.itemName
            item.price=Double.parseDouble(params.price)
            item.amount=Double.parseDouble(params.amount)
            item.quantity=Integer.parseInt(params.quantity)
            item.save(failOnError:true)
            invoice.addToItems(item)
        }
        println"############"+(params.itemName instanceof String[]==true)
        if (params.itemName instanceof String[]==true) {
            for(int i=0; i<params.itemName.size(); i++){
                // println("mmmmmmmmmmmmm"+items[i])
                def item= new Item()
                item.itemName= params.itemName[i]
                item.price=Double.parseDouble(params.price[i])
                item.amount=Double.parseDouble(params.amount[i])
               item.quantity=Integer.parseInt(params.quantity[i])
                item.save(failOnError:true)
                invoice.addToItems(item)
                /*def x = item.save()
                println("ddddddddddddd"+x)*/
            }

        }

        invoice.setVendor(vendor)
        invoice.validate()
        def invoiceId = invoice.save(flush: true, failOnError: true)
        def inid = invoiceId.getId()
        println("ssssssssssssssssss"+invoice.items)
        println"iiiiiiiii"+invoice.id+"ddddddddddddd"+inid
        println("iiiiiiiiiiiiiiiiid    " +invoiceId.vendor )
        redirect(controller: "invoice", action: "aftersave", params: [id: inid, amount:a])
    }


    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def invoicelist() {
        def invoices = Invoice.list()
        render(view: "invoicelist", model: [invoices: invoices] )
    }

    def show(Invoice invoice) {
        respond invoice
    }

    def create() {
        respond new Invoice(params)
    }

    @Transactional
    def save(Invoice invoice) {
        if (invoice == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (invoice.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond invoice.errors, view: 'create'
            return
        }

        invoice.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'invoice.label', default: 'Invoice'), invoice.id])
                redirect invoice
            }
            '*' { respond invoice, [status: CREATED] }
        }
    }

    def edit(Invoice invoice) {
        respond invoice
    }

    @Transactional
    def update(Invoice invoice) {
        if (invoice == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (invoice.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond invoice.errors, view: 'edit'
            return
        }

        invoice.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'invoice.label', default: 'Invoice'), invoice.id])
                redirect invoice
            }
            '*' { respond invoice, [status: OK] }
        }
    }


    @Transactional
    def delete(Invoice invoice) {

        if (invoice == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        invoice.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'invoice.label', default: 'Invoice'), invoice.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'invoice.label', default: 'Invoice'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
    @Transactional
    def list() {
        [invoice: Invoice.list()]
    }
}