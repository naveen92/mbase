package com.naveen.mbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.naveen.mbase.controller.IAccountRepository;
import com.naveen.mbase.entity.Account;


@SpringBootApplication
@EntityScan("com.naveen.mbase.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Configuration
    class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

      @Autowired
      IAccountRepository accountRepository;

      @Override
      public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
      }

      @Bean
      UserDetailsService userDetailsService() {
        return new UserDetailsService() {

          @Override
          public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Account account = accountRepository.findByUsername(username);
            if(account != null) {
            return new User(account.getUsername(), account.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            
            } else {
              throw new UsernameNotFoundException("could not find the user '"
                      + username + "'");
            }
          }
          
        };
      }
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     
      @Override
      protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
        .antMatchers("/evttracker/inc").permitAll()
        .anyRequest().fullyAuthenticated().and().
        //httpBasic().and().
        formLogin().and().
        csrf().disable();
      }
      
    }
}