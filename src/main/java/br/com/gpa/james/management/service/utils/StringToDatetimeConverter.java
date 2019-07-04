package br.com.gpa.james.management.service.utils;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.joda.time.DateTime;


public class StringToDatetimeConverter extends StdConverter<String, DateTime> {

    @Override
    public DateTime convert(String value) {
        return DateTime.parse(value, DateTimeToStringConverter.DATE_TIME_FORMATTER);
    }
}
