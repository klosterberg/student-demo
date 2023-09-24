package com.baeldung.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WorkTimeController {

    WorkTimeService workTimeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond workTimeService.list(params), model:[workTimeCount: workTimeService.count()]
    }

    def show(Long id) {
        respond workTimeService.get(id)
    }

    def create() {
        respond new WorkTime(params)
    }

    def save(WorkTime workTime) {
        if (workTime == null) {
            notFound()
            return
        }

        try {
            workTimeService.save(workTime)
        } catch (ValidationException e) {
            respond workTime.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'workTime.label', default: 'WorkTime'), workTime.id])
                redirect workTime
            }
            '*' { respond workTime, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond workTimeService.get(id)
    }

    def update(WorkTime workTime) {
        if (workTime == null) {
            notFound()
            return
        }

        try {
            workTimeService.save(workTime)
        } catch (ValidationException e) {
            respond workTime.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'workTime.label', default: 'WorkTime'), workTime.id])
                redirect workTime
            }
            '*'{ respond workTime, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        workTimeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'workTime.label', default: 'WorkTime'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'workTime.label', default: 'WorkTime'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
