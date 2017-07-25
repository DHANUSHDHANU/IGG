package com.grailsbrains.auth

import com.grailsbrains.auth.Role
import com.grailsbrains.auth.User
import grails.transaction.Transactional


@Transactional
class UserService {



    def createUser(User user) {
        println(user.toString())
        user.save(failOnError:true)
        println(Role.get(1))
    }
}
