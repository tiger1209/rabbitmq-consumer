package com.edu.rabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    public final static String FANOUT_A = "fanout.A";
    public final static String FANOUT_B = "fanout.B";
    public final static String FANOUT_C = "fanout.C";

    @Bean
    public Queue queueA(){
        return new Queue(FANOUT_A);
    }
    @Bean
    public Queue queueB(){
        return new Queue(FANOUT_B);
    }
    @Bean
    public Queue queueC(){
        return new Queue(FANOUT_C);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }


}
