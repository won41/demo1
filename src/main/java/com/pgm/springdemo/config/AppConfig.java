package com.pgm.springdemo.config;

import com.pgm.springdemo.sample.SampleDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//IoC configuration이라는것
public class AppConfig {
    @Bean
    public SampleDTO myDto1() {
        String[] hobbys={"잠자기", "여행"};
        return new SampleDTO("윤요섭", 25, hobbys);
    }
    @Bean
    public SampleDTO myDto2() {
        String[] hobbys={"등산", "여행"};
        return new SampleDTO("박경미", 29, hobbys);
    }
}
