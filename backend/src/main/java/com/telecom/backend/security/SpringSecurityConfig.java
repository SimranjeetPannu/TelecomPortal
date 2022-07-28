package com.telecom.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.telecom.backend.beans.UserAccount;
import com.telecom.backend.beans.Users;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    String url = "jdbc:mysql://localhost:3306/telecomprojectss";
	String user = "root";
	String password = "Maxo1014!";
	String driver = "com.mysql.cj.jdbc.Driver";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers("/**").hasRole("ADMIN").anyRequest().authenticated()
        .and().formLogin();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        // Schema it expects to be inside schema.xml
        // Need encryption to protext user's passwords
        authBuilder.jdbcAuthentication().dataSource(mySqlDataSource()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public javax.sql.DataSource mySqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // This is a 1-way hash, no going back
        // The defauly BCrypt goes 10 rounds for password "Strength"
        return new BCryptPasswordEncoder();
    }

    @Override
    // @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        // Would not want to setup our userdetails service in this way in prod, just dev/learning
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // Are able to implement custom userdetails since it's an interface
        // We will just use the built in one
        manager.createUser(Users.withUsername("admin").password("admin").roles("ADMIN").build());
        return manager;
    }
}
