package com.baeldung.grails

import grails.gorm.services.Service

@Service(WorkTime)
interface WorkTimeService {

    WorkTime get(Serializable id)

    List<WorkTime> list(Map args)

    Long count()

    void delete(Serializable id)

    WorkTime save(WorkTime workTime)

}