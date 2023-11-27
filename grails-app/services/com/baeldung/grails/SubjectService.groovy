package com.baeldung.grails

import grails.gorm.services.Service

@Service(Subject)
interface SubjectService {

    Subject get(Long id)
    List<Subject> list(Map args)
    Number count()
    void delete(Serializable id)
    Subject update(Serializable id, Long version, String name)
    Subject update(Serializable id, Long version, byte[] featuredImageBytes, String featuredImageContentType)
    Subject save(Subject subject)
    Subject save(String name)

}