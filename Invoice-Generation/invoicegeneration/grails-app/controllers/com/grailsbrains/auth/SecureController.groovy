package com.grailsbrains.auth

import org.springframework.security.access.annotation.Secured

class SecureController {

    def springSecurityService

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def index() {
        println("user name is : " + session.getAttribute('oraganizationName'))
        println("current user name is "   +  springSecurityService.currentUser?.organizationName)
        def user = springSecurityService.currentUser
        render view:"dashboard", model:[user:user]
    }


}
