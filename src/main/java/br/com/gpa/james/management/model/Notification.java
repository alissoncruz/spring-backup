package br.com.gpa.james.management.model;

import br.com.gpa.james.management.enums.EventNotificationPayload;
import org.joda.time.DateTime;

import java.io.Serializable;

public class Notification implements Serializable {
    private String appId;
    private EventNotificationPayload eventNotificationPayload;
    private String payload;
    //private DateTime dateCreated;
    private String status;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public EventNotificationPayload getEventNotificationPayload() {
        return eventNotificationPayload;
    }

    public void setEventNotificationPayload(EventNotificationPayload eventNotificationPayload) {
        this.eventNotificationPayload = eventNotificationPayload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    /*public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
