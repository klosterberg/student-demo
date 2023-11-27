package com.baeldung.grails

class Subject {
    String      name
    byte[]      featuredImageBytes
    String      featuredImageContentType

    static constraints = {
        name maxSize: 255, nullable: false
        featuredImageBytes nullable: true
        featuredImageContentType nullable: true
    }


    static mapping = {
       featuredImageBytes column: 'featured_image_bytes', sqlType: 'longblob'
       // featuredImageBytes column: 'featured_image_bytes', sqlType: 'Blob'
    }
}
