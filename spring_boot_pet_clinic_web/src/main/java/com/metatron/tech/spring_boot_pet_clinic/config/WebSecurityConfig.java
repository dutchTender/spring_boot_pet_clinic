package com.metatron.tech.spring_boot_pet_clinic.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.queries.users-query}")
    private String userQuery;

    @Value("${spring.queries.roles-query}")
    private String roleQuery;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final DataSource dataSource;

    public WebSecurityConfig( BCryptPasswordEncoder bCryptPasswordEncoder, DataSource dataSource) {

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(roleQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/resources/**", "/h2-console/**", "/console/**","/webjars/**").permitAll()
                //.antMatchers("/vets**","/owners**").hasRole("vet")
                //.antMatchers("/owners","owner","/pet").hasRole("owner")
                //.antMatchers("/owner**","/vet**","/pet**").hasRole("admin")
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



    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    /*
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
*/
}
