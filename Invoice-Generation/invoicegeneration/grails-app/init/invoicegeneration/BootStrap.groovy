package invoicegeneration

import com.grailsbrains.auth.Role
import com.grailsbrains.auth.User
import com.grailsbrains.auth.UserRole
import com.grailsbrains.entity.Address
import com.grailsbrains.entity.Vendor


class BootStrap {

    def init = { servletContext ->

         def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole  = new Role(authority: 'ROLE_USER').save()

        def testUser = new User(username: 'dhanush@gmail.com', password: 'password', organizationName: 'GrailsBrains', workingArea: 'software').save(failOnError:true)
        def testUser1 = new User(username: 'raj', password: 'password', organizationName: 'GrailsBrains', workingArea: 'software').save(failOnError:true)

        def testVendor = new Vendor(firstName: 'dhanush',lastName: 'd', email: 'dhanush@gmail.com',phoneNumber: 64685145645, mobileNumber: 16584654,fax: 5458845, user: testUser)
        def testVendorAddress = new Address(street: 'kotra', city: 'bhopal',pincode: 462003, state: 'mp', country: 'india')//.save(failOnError:true)
        testVendor.addToAddresses(testVendorAddress)
        testVendor.validate()
        testVendor.save(flush:true,failOnError:true)
        println"ppppppppppppppppp"+testVendor
        /* def testClient = new Client(firstName: 'dhanush',lastName: 'd',organizationName: 'abcdef',phoneNumber: 548454,mobileNumber: 464545,fax: 4685414,email: 'miohknbub').save(failOnError:true)

        def testClientAddress = new Address(street: 'kotra', city: 'bhopal',pincode: 462003, state: 'mp', country: 'india').save(failOnError:true)
        def testTax =new Tax(taxId: '1',taxName:'gst',taxRate: '1234')
        def testItem = new Item(itemName: 'xyz',quantity: 5,price: 1500, tax:testTax).save(failOnError:true)
        def testInvoice = new Invoice(title: 'abc',referenceNumber: 1564,poNumber: 15645,invoiceDate: new Date(),dueDate: new Date(),items: testItem, client: testClient, vendor: testVendor).save(failOnError:true)*/

        UserRole.create testUser, userRole
        UserRole.create testUser, adminRole
        UserRole.create testUser1, userRole
        UserRole.create testUser1, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        println(User.count())
        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 4

    }
    def destroy = {
    }
}