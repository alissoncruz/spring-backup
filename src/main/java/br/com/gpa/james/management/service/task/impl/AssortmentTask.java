package br.com.gpa.james.management.service.task.impl;

import br.com.gpa.james.management.enums.TaskEnum;
import br.com.gpa.james.management.model.Execute;
import br.com.gpa.james.management.service.task.FactoryTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static org.joda.time.DateTime.now;


@Component
public class AssortmentTask {
    private final Logger log =  LoggerFactory.getLogger(AssortmentTask.class);

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Value("${scheduled.assortment}")
    private boolean assortment;

    @Autowired
    @Qualifier("assortmentScheduledTask")
    private FactoryTask assortmentScheduledTask;

    @Scheduled(cron = "*/30 * * * * *", zone = TIME_ZONE)
    public void process() {
        log.info("Start method process");

        if (assortment)
            assortmentStart();

        log.info("Finish method process");
    }

    private void assortmentStart(){
        Execute execute = new Execute();
        execute.setTask(TaskEnum.ASSORTMENT_TASK);
        execute.setDateTime(now());
        assortmentScheduledTask.execute(execute);

    }

}
