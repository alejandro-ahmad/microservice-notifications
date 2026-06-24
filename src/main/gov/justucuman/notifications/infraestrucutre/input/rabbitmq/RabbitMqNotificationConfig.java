package gov.justucuman.notifications.infraestrucutre.input.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMqNotificationConfig {
    public static final String QUEUE_NAME = "notifications-employee-queue";
    public static final String EXCHANGE_NAME = "personal-rrhh-exchange";
    public static final String ROUTING_KEY = "justucuman.personal_rrhh.1.event.employee.created";

    @Bean
    public Queue employeeQueue(){
        return new Queue(QUEUE_NAME,true);
    }

    @Bean
    public TopicExchange personalRrhhExchange(){
        return new TopicExchange(EXCHANGE_NAME,true,false);
    }

    @Bean
    public Binding bindingEmployeeQueue(Queue employeeQueue, TopicExchange personalRrhhExchange){
        return BindingBuilder.bind(employeeQueue).to(personalRrhhExchange).with(ROUTING_KEY);
    }
}
