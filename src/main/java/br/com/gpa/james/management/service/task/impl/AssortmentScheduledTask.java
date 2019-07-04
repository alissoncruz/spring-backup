package br.com.gpa.james.management.service.task.impl;

import br.com.gpa.james.management.config.RabbitConfig;
import br.com.gpa.james.management.enums.EventNotificationPayload;
import br.com.gpa.james.management.enums.TaskEnum;
import br.com.gpa.james.management.model.Assortment;
import br.com.gpa.james.management.model.Execute;
import br.com.gpa.james.management.model.Notification;
import br.com.gpa.james.management.model.PriceSellGpa;
import br.com.gpa.james.management.repository.PriceSellRepository;
import br.com.gpa.james.management.service.AssortmentService;
import br.com.gpa.james.management.service.PriceSellService;
import br.com.gpa.james.management.service.processor.AbstractProcessor;
import br.com.gpa.james.management.service.task.FactoryTask;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static br.com.gpa.james.management.enums.EventNotificationPayload.ASSORTMENT;
import static br.com.gpa.james.management.service.utils.ParserJsonUtil.convertObjectToJson;
import static java.util.Objects.nonNull;

@Service("assortmentScheduledTask")
public class AssortmentScheduledTask extends FactoryTask {

    private final Logger log =  LoggerFactory.getLogger(AssortmentScheduledTask.class);
    /*
    @Autowired
    @Qualifier("template")
    private AmqpTemplate amqpTemplate;*/

//    @Autowired
//    private PriceSellRepository priceSellRepository;

    @Value("${appId:000}")
    private String appId;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PriceSellService priceSellService;

    @Autowired
    private AssortmentService assortmentService;

    @Override
    public TaskEnum getTaskEnum() {
        return TaskEnum.ASSORTMENT_TASK;
    }

    private final static String ROUTE_KEY = "foo.bar.baz";

    public AssortmentScheduledTask(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public AbstractProcessor createProcessor(TaskEnum taskEnum) {
        if (taskEnum == TaskEnum.ASSORTMENT_TASK){
            return new AssortmentProcess();
        }
        return null;
    }

    @Override
    public List<TaskEnum> getTasks(Execute execute) {
        List<TaskEnum> taskEnums = new ArrayList<>();
        taskEnums.add(TaskEnum.ASSORTMENT_TASK);
        return taskEnums;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("AssortmentScheduledTask finish.");
    }

    private class AssortmentProcess extends AbstractProcessor{

        @Override
        public Object search(DateTime dateTime) {

            ArrayList<Assortment> assortments = new ArrayList<>();

            List<PriceSellGpa> priceSells = priceSellService.findAll();

            priceSells.stream().forEach(price -> {
                Assortment assortment = new Assortment();
                assortment = assortmentService.fillAssortment(assortment, price);
                assortments.add(assortment);
            });

            return assortments;
        }

        @Override
        protected long send(Object object, DateTime dateTime) {
            List<Assortment> assortments = new ArrayList<>();
            assortments = (List<Assortment>) object;
            assortments.stream()
                    .filter(assortment -> nonNull(assortment))
                    .forEach(assortment -> {
                        String payload = convertObjectToJson(assortment);
                        log.debug(payload);
                        prepareNotification(dateTime, payload, ASSORTMENT, "status");
            });
            return assortments.stream().count();
        }
    }

    protected void prepareNotification(DateTime dateTime, String payload, EventNotificationPayload eventNotificationPayload, String status){
        log.debug("Start method prepareNotification");

        Notification notification = new Notification();
        notification.setAppId(appId);
        //notification.setDateCreated(dateTime);
        notification.setEventNotificationPayload(eventNotificationPayload);
        notification.setPayload(payload);
        notification.setStatus(status);
        String payloadNotification = convertObjectToJson(notification);

        log.debug(payloadNotification);

        rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName, ROUTE_KEY, payloadNotification);

        log.debug("Finish method prepareNotification");
    }
}
