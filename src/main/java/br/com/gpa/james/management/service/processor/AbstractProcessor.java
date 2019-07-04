package br.com.gpa.james.management.service.processor;

import br.com.gpa.james.management.model.Execute;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.nonNull;
import static org.joda.time.DateTime.now;

public abstract class AbstractProcessor {

    private final Logger log =  LoggerFactory.getLogger(AbstractProcessor.class);

    public abstract Object search(final DateTime dateTime);

    protected abstract long send(final Object object, final DateTime dateTime);

    public void process(final Execute execute){
        DateTime dateTime = now();
        if (nonNull(search(dateTime))){
            Object obj = search(now());
            if (nonNull(obj)) {
                send(obj, dateTime);
            } else {
                log.error("Processor - Error to send.");
            }

        } else {
            log.error("Processor - Error to search.");
        }


    }

}
