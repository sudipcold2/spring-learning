package com.sudip.learn.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication

//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//                .withUser(users.username("mary").password("test123").roles("EMPLOYEE","MANAGER"))
//                .withUser(users.username("susan").password("test123").roles("EMPLOYEE","ADMIN"));
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().
//                    anyRequest().authenticated()
//                .and()
//                .formLogin()
//                    .loginPage("/showMyLogInPage")
//                    .loginProcessingUrl("/authenticateTheUser")
//                    .permitAll()
//                .and()
//                    .logout().permitAll();

        http.authorizeRequests()
                    .antMatchers("/").permitAll()  // allow public access to home page
                    .antMatchers("/employees").hasRole("EMPLOYEE")
                    .antMatchers("/leaders/**").hasRole("MANAGER")
                    .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/showMyLogInPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/")  // after logout then redirect to landing page (root)
                    .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
