package stock

import grails.validation.ValidationException

import java.sql.Timestamp

import static org.springframework.http.HttpStatus.*

class FundController {

    def springSecurityService
    FundService fundService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond fundService.list(params), model:[fundCount: fundService.count()]
    }

    def show(Long id) {
        respond fundService.get(id)
    }

    def create() {
        Fund fund = new Fund()
        fund.name = params.name
        fund.description = params.description
        fund.timestamp = new Date()
        fund.user = springSecurityService.currentUser

        respond fund
    }

    def save(Fund fund) {
        if (fund == null) {
            notFound()
            return
        }

        try {
            fundService.save(fund)
        } catch (ValidationException e) {
            respond fund.errors, view:'create'
            return
        }

        redirect fund
    }

    def edit(Long id) {
        respond fundService.get(id)
    }

    def update(Fund fund) {
        if (fund == null) {
            notFound()
            return
        }

        try {
            fundService.save(fund)
        } catch (ValidationException e) {
            respond fund.errors, view:'edit'
            return
        }

        redirect fund
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        fundService.delete(id)

        redirect action:"index", method:"GET"
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fund.label', default: 'Fund'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
