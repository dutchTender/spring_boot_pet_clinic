package com.metatron.tech.spring_boot_pet_clinic.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/resources/**", "/h2-console/**", "/console/**").permitAll()
                .antMatchers("/vets**","/owners**").hasRole("vet")
                .antMatchers("/owners","owner","/pet").hasRole("owner")
                .antMatchers("/owner**","/vet**","/pet**").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();



        // supports h2-console access
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }


    // in memory user and roles
    // we will replace this with a database version

    // also we will do one with oAuth (web Identity management service)

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("owner")
                        .build();
        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("lzhang421@gmail.com")
                        .password("admin")
                        .roles("owner")
                        .build();
        UserDetails user3 =
                User.withDefaultPasswordEncoder()
                        .username("beskola@gmail.com")
                        .password("admin")
                        .roles("owner")
                        .build();
        return new InMemoryUserDetailsManager(user,user2,user3);
    }

}
