package com.baeldung.grails.binding

import grails.databinding.converters.ValueConverter
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import java.time.LocalTime

@CompileStatic
@Slf4j
class LocalTimeValueConverter implements ValueConverter {
    LocalTimeValueConverter() {
        log.debug("LocalTimeValueConverter created")
    }
    @Override
    boolean canConvert(Object value) {
        return value instanceof String
    }

    @Override
    Object convert(Object value) {
        return value ? LocalTime.parse(value.toString()) : null
    }

    @Override
    Class<?> getTargetType() {
        return LocalTime
    }
}
