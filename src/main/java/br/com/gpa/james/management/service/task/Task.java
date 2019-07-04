package br.com.gpa.james.management.service.task;

import br.com.gpa.james.management.enums.TaskEnum;
import br.com.gpa.james.management.model.Execute;
import br.com.gpa.james.management.service.processor.AbstractProcessor;

import java.util.List;

public interface Task {

    AbstractProcessor createProcessor(final TaskEnum taskEnum);

    void execute(Execute execute);

    List<TaskEnum> getTasks(Execute execute);
}
