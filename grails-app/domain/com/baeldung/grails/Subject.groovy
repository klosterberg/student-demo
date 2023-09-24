package com.baeldung.grails

class Subject {
    String name
    static constraints = {
        name maxSize: 255, nullable: false
    }


    @Override
    public String toString() {
        return name;
    }
}
