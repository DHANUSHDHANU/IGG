package com.grailsbrains.entity

import com.grailsbrains.entity.Tax
import grails.transaction.Transactional

@Transactional
class TaxService {

    def taxServiceMethod(Tax tax) {
        def savedTax = tax.save(failOnError:true)
        return savedTax
    }
}
