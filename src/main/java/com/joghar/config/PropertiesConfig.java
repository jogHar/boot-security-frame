package com.joghar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:properties/public.properties")
public class PropertiesConfig {
}
