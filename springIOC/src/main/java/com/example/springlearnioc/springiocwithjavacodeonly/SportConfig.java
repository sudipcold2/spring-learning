package com.example.springlearnioc.springiocwithjavacodeonly;

import com.example.springlearnioc.springiocwithjavacodeonly.helper.Coach;
import com.example.springlearnioc.springiocwithjavacodeonly.helper.FortuneService;
import com.example.springlearnioc.springiocwithjavacodeonly.helper.SadFortuneService;
import com.example.springlearnioc.springiocwithjavacodeonly.helper.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
