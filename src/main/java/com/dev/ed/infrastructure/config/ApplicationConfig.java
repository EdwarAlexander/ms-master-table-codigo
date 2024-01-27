package com.dev.ed.infrastructure.config;

import com.dev.ed.application.service.CustomerService;
import com.dev.ed.application.service.PublicityService;
import com.dev.ed.application.usecase.CustomerServiceImpl;
import com.dev.ed.application.usecase.PublicityServiceImpl;
import com.dev.ed.domain.ports.out.CustomerOut;
import com.dev.ed.domain.ports.out.PublicityOut;
import com.dev.ed.infrastructure.repository.adapter.CustomerRepositoryAdapter;
import com.dev.ed.infrastructure.repository.adapter.PublicityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public CustomerService customerService(CustomerOut customerOut){
        return new CustomerService(new CustomerServiceImpl(customerOut));
    }

    @Bean
    public CustomerOut customerOut(CustomerRepositoryAdapter customerRepositoryAdapter){
        return customerRepositoryAdapter;
    }
    @Bean
    public PublicityService publicityService(PublicityOut publicityOut){
        return new PublicityService(new PublicityServiceImpl(publicityOut));
    }
    @Bean
    public PublicityOut publicityOut(PublicityRepositoryAdapter publicityRepositoryAdapter){
        return publicityRepositoryAdapter;
    }
}
