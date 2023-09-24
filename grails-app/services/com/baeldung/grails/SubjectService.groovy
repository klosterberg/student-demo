package com.baeldung.grails

import grails.gorm.services.Service

@Service(Subject)
interface SubjectService {

    Subject get(Serializable id)

    List<Subject> list(Map args)

    Long count()

    void delete(Serializable id)

    Subject save(Subject subject)

}