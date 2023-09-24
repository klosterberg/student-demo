package com.baeldung.grails

import grails.databinding.BindingFormat

import java.sql.Date
import java.time.LocalTime

class WorkTime {
    Student student
    Date date

    @BindingFormat("HH:mm")
    LocalTime start
    @BindingFormat("HH:mm")
    LocalTime end
    String comment

    static constraints = {
        student nullable: false
    }
}
