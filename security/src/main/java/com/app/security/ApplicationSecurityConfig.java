package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig  {

    @Autowired
    private  UserDetailsService userDetailsService;
    @Bean
    public DaoAuthenticationProvider authprovider(){
        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());    depricated
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }
@Bean
public void Configure(HttpSecurity http) throws Exception{

//   http.csrf(csrf->csrf.disable())
//           .authorizeHttpRequests(authorize->authorize.requestMatchers("/Login")
//           .permitAll()).formLogin(formlogin->formlogin.loginPage("/Login").permitAll())
//           .logout(logout->logout.invalidateHttpSession(true).clearAuthentication(true)
//                   .logoutRequestMatcher( ));


    }

//    @Bean
//   public UserDetailsService userDetailsService(){
//        UserDetails user= User.builder().username("vaishnav").password(passwordEncoder().encode("vaish")).roles("NORMAL").build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
