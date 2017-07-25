package com.grailsbrains.entity

import com.grailsbrains.entity.Signup
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class SignupController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured('permitAll')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Signup.list(params), model:[signupCount: Signup.count()]
    }

    def show(Signup signup) {
        respond signup
    }

    def create() {
        respond new Signup(params)
    }

    @Transactional
    def save(Signup signup) {
        if (signup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (signup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond signup.errors, view:'create'
            return
        }

        signup.save flush:true


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'signup.label', default: 'Signup'), signup.id])
                redirect signup
            }
            '*' { respond signup, [status: CREATED] }
        }
    }

    def edit(Signup signup) {
        respond signup
    }

    @Transactional
    def update(Signup signup) {
        if (signup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (signup.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond signup.errors, view:'edit'
            return
        }

        signup.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'signup.label', default: 'Signup'), signup.id])
                redirect signup
            }
            '*'{ respond signup, [status: OK] }
        }
    }

    @Transactional
    def delete(Signup signup) {

        if (signup == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        signup.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'signup.label', default: 'Signup'), signup.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'signup.label', default: 'Signup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
