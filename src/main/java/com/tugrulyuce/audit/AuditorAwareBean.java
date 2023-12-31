package com.tugrulyuce.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

//AuditorAware: Sistemdeki kullanıcı loglama yapacak
@Configuration
public class AuditorAwareBean {

    @Bean
    public AuditorAware<String> auditorAwareMethod(){
        return new AuditorAwareImpl();
    }
}
