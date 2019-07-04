package br.com.gpa.james.management.config;

//import br.com.gpa.arquitetura.amqp.ClassTypeDelegatingMessageConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private Logger log = LoggerFactory.getLogger(RabbitConfig.class);
  /*  public static final String topicExchangeName = "products-integration-exchange";

    static final String queueName = "products-integration";*/

    public static final String topicExchangeName = "api-core-dispatch-exchange";
    public static final String queueName = "api-core-dispatch";
    


    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }


    /*@Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routingKey_James");
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
                                                                               ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setConcurrentConsumers(1);
        factory.setMessageConverter(new SimpleMessageConverter());
        factory.setErrorHandler(rabbitErrorHandler());
        return factory;
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory, ClassTypeDelegatingMessageConverter converter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(converter);
        template.setChannelTransacted(true);
        return template;
    }

    public ErrorHandler rabbitErrorHandler() {
        log.info("Ola Erro");
        return null;
    }*/

}
