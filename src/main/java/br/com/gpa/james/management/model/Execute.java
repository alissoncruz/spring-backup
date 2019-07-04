package br.com.gpa.james.management.model;

import br.com.gpa.james.management.enums.TaskEnum;
import org.joda.time.DateTime;

import java.io.Serializable;

public class Execute implements Serializable {

    private TaskEnum task;

    private DateTime dateTime;

    public TaskEnum getTask() {
        return task;
    }

    public void setTask(TaskEnum task) {
        this.task = task;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
