package org.joostit.shoppr.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ShopprSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/styles/css/**").permitAll()
                    .antMatchers("/", "/home").permitAll()
                    .antMatchers("/", "/index").permitAll()
                    .antMatchers("/", "/bla").permitAll()
                    .antMatchers("/", "/layout").permitAll()
                    .antMatchers("/", "/error").permitAll()
                    .antMatchers("/", "/login").permitAll()
                    .antMatchers("/", "/about").permitAll()
                    .antMatchers("/", "/api/getLists").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    //.loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .csrf()
                    .disable().cors();

    }


    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/webjars/**", "/js/**");
    }
}
