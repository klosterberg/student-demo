package com.baeldung.grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SubjectController {

    SubjectService subjectService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond subjectService.list(params), model:[subjectCount: subjectService.count()]
    }

    def show(Long id) {
        respond subjectService.get(id)
    }

    def create() {
        respond new Subject(params)
    }

    def save(Subject subject) {
        if (subject == null) {
            notFound()
            return
        }

        try {
            subjectService.save(subject)
        } catch (ValidationException e) {
            respond subject.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'subject.label', default: 'Subject'), subject.id])
                redirect subject
            }
            '*' { respond subject, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond subjectService.get(id)
    }

    def update(Subject subject) {
        if (subject == null) {
            notFound()
            return
        }

        try {
            subjectService.save(subject)
        } catch (ValidationException e) {
            respond subject.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'subject.label', default: 'Subject'), subject.id])
                redirect subject
            }
            '*'{ respond subject, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        subjectService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'subject.label', default: 'Subject'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'subject.label', default: 'Subject'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def editFeaturedImage(Long id) {
        Subject subject = subjectService.get(id)
        if (!subject) {
            notFound()
        }
        [subject: subject]
    }

    def uploadFeaturedImage(FeaturedImageCommand cmd) {
        if (cmd == null) {
            notFound()
            return
        }

        if (cmd.hasErrors()) {
            respond(cmd.errors, model: [subject: cmd], view: 'editFeaturedImage')
            return
        }

        Subject subject = subjectService.update(cmd.id,
                cmd.version,
                cmd.featuredImageFile.bytes,
                cmd.featuredImageFile.contentType
        )

        if (subject == null) {
            notFound()
            return
        }

        if (subject.hasErrors()) {
            respond(subject.errors, model: [subject: subject], view: 'editFeaturedImage')
            return
        }

        Locale locale = request.locale
        // flash.message = crudMessageService.message(CRUD.UPDATE, domainName(locale), cmd.id, locale)
        flash.message = "crudMessageService.message(CRUD.UPDATE, domainName(locale), cmd.id, locale)"
        redirect subject
    }

    def featuredImage(Long id) {
        Subject subject = subjectService.get(id)
        if (!subject || subject.featuredImageBytes == null) {
            notFound()
            return
        }
        render file: subject.featuredImageBytes,
                contentType: restaurant.featuredImageContentType

    }
}
