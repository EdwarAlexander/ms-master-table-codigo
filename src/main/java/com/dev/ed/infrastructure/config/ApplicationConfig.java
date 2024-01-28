package com.dev.ed.infrastructure.config;

import com.dev.ed.application.service.CapturesService;
import com.dev.ed.application.service.CustomerService;
import com.dev.ed.application.service.PublicityService;
import com.dev.ed.application.service.SellerService;
import com.dev.ed.application.usecase.CapturesServiceImpl;
import com.dev.ed.application.usecase.CustomerServiceImpl;
import com.dev.ed.application.usecase.PublicityServiceImpl;
import com.dev.ed.application.usecase.SellerServiceImpl;
import com.dev.ed.domain.ports.out.CapturesOut;
import com.dev.ed.domain.ports.out.CustomerOut;
import com.dev.ed.domain.ports.out.PublicityOut;
import com.dev.ed.domain.ports.out.SellerOut;
import com.dev.ed.infrastructure.repository.adapter.CapturesRepositoryAdapter;
import com.dev.ed.infrastructure.repository.adapter.CustomerRepositoryAdapter;
import com.dev.ed.infrastructure.repository.adapter.PublicityRepositoryAdapter;
import com.dev.ed.infrastructure.repository.adapter.SellerRepositoryAdapter;
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

    @Bean
    public SellerService sellerService(SellerOut sellerOut){
        return new SellerService(new SellerServiceImpl(sellerOut));
    }
    @Bean
    public SellerOut sellerOut(SellerRepositoryAdapter sellerRepositoryAdapter){
        return sellerRepositoryAdapter;
    }
    @Bean
    public CapturesService capturesService(CapturesOut capturesOut){
        return new CapturesService(new CapturesServiceImpl(capturesOut));
    }
    @Bean
    public CapturesOut capturesOut(CapturesRepositoryAdapter capturesRepositoryAdapter){
        return capturesRepositoryAdapter;
    }
}
