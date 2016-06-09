package com.alatfa.gps.security;

import com.alatfa.gps.model.Utilisateur;
import com.alatfa.gps.repositories.RoleRepository;
import com.alatfa.gps.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by UNKNOWN on 16/05/2016.
 */

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    UtilisateurRepository accountRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Utilisateur account = accountRepository.findByLogin(username);
                String role = "utilisateur";
                if(account.getRole() != null)
                    role = account.getRole().getName();

                System.out.println("roooole : "+role);
        if(role == "" || role == null) role = "utilisateur";
                if(account != null) {
                    return new User(account.getLogin(), account.getPassword(), true, true, true, true,
                            AuthorityUtils.createAuthorityList(role));
                } else {
                    throw new UsernameNotFoundException("Utilisateur introuvable !! '"+ username + "'");
                }
            }

        };
    }
}