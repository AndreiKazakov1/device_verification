package by.iba.kazakov.device_verification.configs;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**", "/client", "/verifier", "/fragments").authenticated()//???
                .antMatchers("/admin/**").hasRole("ADMIN")//0:11
                .and()
                .formLogin().permitAll()  //смотри здесь https://sysout.ru/spring-custom-login-form/
                .loginPage("/signin")






    }
}
