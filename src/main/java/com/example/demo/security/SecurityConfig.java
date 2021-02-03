package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    // this default Authentication method has one user and password
    // so we need to specify source for all  users and roles
    // by default spring security use password uncoded it try to decrypt any password
    // we user {noop} in password to ignore decrypt  password
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        // local object of crypt password
        PasswordEncoder passwordEncoder=passwordEncoder();

        auth.inMemoryAuthentication().withUser("user1").password( passwordEncoder.encode("123")).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password("{noop}123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user2").password("{noop}123").roles("ADMIN" ,"USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

         // use default form login provide by spring , we can set our one form . loginPage("/login")  rest Controller
         // http.httpBasic() basic from provide by browser
            http.formLogin();

          // 1 -Check  specific http requests must to be login and has Role
             http.authorizeRequests().antMatchers("/personnas**/**").hasRole("ADMIN");
             //http.authorizeRequests().antMatchers(HttpMethod.GET ,"/personnas**/**").hasAnyAuthority("USER");

          //2-Allow specific  http requests to target resource
             http.authorizeRequests().antMatchers("/consol**/**").permitAll();

        //3-ALL other http requests must  to be login
            http.authorizeRequests().anyRequest().authenticated();


       // http.csrf().disable(); //  if we use JWT  we should disable  sand and check  token input hidden with  Coockies session_id
       // http.exceptionHandling().accessDeniedPage("/error");



    }

    @Bean
  public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
  }

}
