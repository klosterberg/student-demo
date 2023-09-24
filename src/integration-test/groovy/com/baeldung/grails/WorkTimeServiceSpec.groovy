package com.baeldung.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WorkTimeServiceSpec extends Specification {

    WorkTimeService workTimeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new WorkTime(...).save(flush: true, failOnError: true)
        //new WorkTime(...).save(flush: true, failOnError: true)
        //WorkTime workTime = new WorkTime(...).save(flush: true, failOnError: true)
        //new WorkTime(...).save(flush: true, failOnError: true)
        //new WorkTime(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //workTime.id
    }

    void "test get"() {
        setupData()

        expect:
        workTimeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<WorkTime> workTimeList = workTimeService.list(max: 2, offset: 2)

        then:
        workTimeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        workTimeService.count() == 5
    }

    void "test delete"() {
        Long workTimeId = setupData()

        expect:
        workTimeService.count() == 5

        when:
        workTimeService.delete(workTimeId)
        sessionFactory.currentSession.flush()

        then:
        workTimeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        WorkTime workTime = new WorkTime()
        workTimeService.save(workTime)

        then:
        workTime.id != null
    }
}
