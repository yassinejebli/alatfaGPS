
package com.alatfa.gps.security;


/**
 * Created by UNKNOWN on 15/05/2016.
 */


import com.alatfa.gps.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

/* @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);//.passwordEncoder(passwordencoder());
    }*//*

*/
/*
    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {


/*        http
                .authorizeRequests()
                .antMatchers("/Content*","/Scripts*","/css*","/fonts*","/reports*").permitAll()//ignorer
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/Login").usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .permitAll();*//*


        */
            http.authorizeRequests()
                .antMatchers("/*").hasAnyAuthority("utilisateur","admin").anyRequest().permitAll()//.hasRole("Caissier")
  //              .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout").permitAll().and().csrf().disable();
/*


       */
/*http.authorizeRequests()
                .antMatchers("admin*/
/*").hasAuthority("admin").anyRequest().permitAll()//.hasRole("Caissier")
                //              .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout").permitAll().and().csrf().disable();*/

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        System.out.println("aaaaa");
        web
                .ignoring().antMatchers("/Content*/","/Scripts*/","/files*/","/css*/","/rest*/","/rest/*");
    }



/*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .withUser("a").password("b").roles("Caissier");

    }*/

}
