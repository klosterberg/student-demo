package com.baeldung.grails

class Plan {
    String name

    List<Subject> subjects

    Subject subject1

    Subject subject2

    static constraints = {
        name maxSize: 255, nullable: false
    }
}
