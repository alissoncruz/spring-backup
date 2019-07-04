package br.com.gpa.james.management.enums;

public enum EventNotificationPayload {

    ASSORTMENT("ASSORTMENT"),
    PRICE("PRICE"),
    STORAGE("STORAGE");

    public String event;
    EventNotificationPayload(String value) {
        event = value;
    }

    public String getEvent() {
        return event;
    }
}
