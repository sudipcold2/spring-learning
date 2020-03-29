package com.sudip.learn.springconfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sudip.learn")
@PropertySource("classpath:persistence-mssql.properties")
public class RootAppConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource securityDataSource(){
        ComboPooledDataSource comboPooledDataSource =
                new ComboPooledDataSource();

        try {
            comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
        comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));

        comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        comboPooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        comboPooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        comboPooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return comboPooledDataSource;
    }

    private int getIntProperty(String propertyName){
        String prop = env.getProperty(propertyName);
        int val = Integer.parseInt(prop);

        return val;
    }

    //Add static resources e.g. images, js, css etc. implementation coming from WebMvcConfigurer
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
