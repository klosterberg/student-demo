package com.baeldung.grails

import java.sql.Date
import grails.databinding.BindingFormat

import java.time.LocalDate
import java.time.LocalTime

class Student
{
    //@BindingFormat('MMddyyyy')yyyy-MM-dd HH:mm:ss z
    @BindingFormat(code ='date.formats.birthdays')
    Date   birthDate
    String firstName
    String lastName
    static constraints = {
        firstName maxSize: 255
        lastName  maxSize: 255
    }


    @Override
    public String toString() {
        return "$firstName $lastName"
    }
}
