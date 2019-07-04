package br.com.gpa.james.management.service.task;

import br.com.gpa.james.management.model.Execute;
import br.com.gpa.james.management.service.processor.AbstractProcessor;
import br.com.gpa.james.management.enums.TaskEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

import static java.util.Objects.nonNull;

public abstract class FactoryTask implements Task, InitializingBean {

    private final Logger log =  LoggerFactory.getLogger(FactoryTask.class);

    public abstract TaskEnum getTaskEnum();

    @Override
    public void execute(Execute execute) {
        log.info("Start method execute.");

        List<TaskEnum> tasks = getTasks(execute);
        tasks.stream()
                .filter(task -> nonNull(task))
                .forEach(task -> {
                    AbstractProcessor processor = createProcessor(task);
                    processor.process(execute);
        });

        log.info("Finish method execute.");
    }

    @Override
    public abstract List<TaskEnum> getTasks(Execute execute);

}
