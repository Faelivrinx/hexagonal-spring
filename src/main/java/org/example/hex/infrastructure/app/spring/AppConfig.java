package org.example.hex.infrastructure.app.spring;

import lombok.extern.slf4j.Slf4j;
import org.example.hex.domain.order.OrderFacade;
import org.example.hex.domain.order.outgoing.OrderStore;
import org.example.hex.infrastructure.domain.order.adapter.secondary.InMemoryOrderStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfig {

    @Bean
    OrderFacade orderFacade(OrderStore orderStore){
        return new OrderFacade(orderStore);
    }

    @Bean
    OrderStore orderStore(){
        return new InMemoryOrderStore();
    }

}
