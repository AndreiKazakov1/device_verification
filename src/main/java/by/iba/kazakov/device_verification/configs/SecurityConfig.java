package by.iba.kazakov.device_verification.configs;

import by.iba.kazakov.device_verification.services.implementations.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.security.Principal;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserImpl userImpl;

    @Autowired
    public void setUserImpl(UserImpl userImpl){
        this.userImpl = userImpl;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/admin/**", "/client/**", "/verifier/**").authenticated()//???
                .antMatchers("/verifier/**").hasAnyRole("VERIFIER", "ADMIN")
                .antMatchers("/client/**").hasAnyRole("CLIENT", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")//0:11
                .antMatchers("/registrationChoice/**", "/verifierRegistrationForm/**", "/verifierRegistration",
                        "/newVerifierRegistrationSubmit","/clientRegistration").anonymous()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin().permitAll()  //смотри здесь https://sysout.ru/spring-custom-login-form/
                .loginPage("/login")
                //.loginProcessingUrl("/login")
                .defaultSuccessUrl("/index", true)
                 .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/");

    }

   // https://www.baeldung.com/spring-redirect-after-login]

   /* public String pageChoice (Principal principal){
        String url = "";
        String role = principal.getName();
        System.out.printf(role);
        if (role.equals("ROLE_VERIFIER")) url = "/verifier";
        else if (role.equals("ROLE_ADMIN")) url = "/indexx";
        return url;
    }
*/



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userImpl);
        return authenticationProvider;
    }


}
