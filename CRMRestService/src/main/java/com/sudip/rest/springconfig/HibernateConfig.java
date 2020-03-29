package com.sudip.rest.springconfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sudip.rest")
@EnableTransactionManagement
@PropertySource("classpath:persistence-mssql.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean(destroyMethod = "close")
    public DataSource myDataSource(){
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

    @Bean
    public LocalSessionFactoryBean sessionFactory(){

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(myDataSource());

        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));

        Properties hibernateProp = new Properties();
        hibernateProp.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProp.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        sessionFactory.setHibernateProperties(hibernateProp);

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private int getIntProperty(String propertyName){
        String prop = env.getProperty(propertyName);
        int val = Integer.parseInt(prop);

        return val;
    }
}
