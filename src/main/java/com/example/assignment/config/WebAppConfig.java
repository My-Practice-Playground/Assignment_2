package com.example.assignment.config;

import com.example.assignment.WebAppInitializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = WebAppInitializer.class)
@EnableWebMvc
public class WebAppConfig {

    @Bean
    public ModelMapper modelMapper() {return new ModelMapper();}
}
