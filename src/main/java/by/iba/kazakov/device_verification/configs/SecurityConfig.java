package by.iba.kazakov.device_verification.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**", "/client/**", "/verifier/**").authenticated()//???
                .antMatchers("/admin/**").hasRole("ADMIN")//0:11
                .antMatchers("/registrationChoice/**").anonymous()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin().permitAll()  //смотри здесь https://sysout.ru/spring-custom-login-form/
                .loginPage("/login")
                //.loginProcessingUrl("/login")
                .defaultSuccessUrl("/index")
                 .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/login");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        //authenticationProvider.setUserDetailsService();
        return authenticationProvider;
    }



}
