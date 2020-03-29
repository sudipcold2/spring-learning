package com.sudip.learn.springconfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sudip.learn")
@EnableTransactionManagement
public class HibernateConfig {

    @Bean(destroyMethod = "close")
    public DataSource myDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setForceUseNamedDriverClass(true);
            dataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setJdbcUrl("jdbc:sqlserver://127.0.0.1:1433;databaseName=springmvchibernate");
            dataSource.setUser("sa");
            //add database password in ***********
            dataSource.setPassword("*******");

            dataSource.setMinPoolSize(5);
            dataSource.setMaxPoolSize(20);
            dataSource.setMaxIdleTime(30000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan("com.sudip.learn.entity");


        Properties hibernateProp = new Properties();
        hibernateProp.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        hibernateProp.setProperty("hibernate.show_sql", "true");
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
}
