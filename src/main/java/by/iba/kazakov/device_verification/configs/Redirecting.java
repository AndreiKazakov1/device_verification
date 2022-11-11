package by.iba.kazakov.device_verification.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class Redirecting  implements WebMvcConfigurer {

    @Override
    public void addViewControllers (ViewControllerRegistry registry){
        registry.addViewController("/admin").setViewName("admin/admin");
        registry.addViewController("/verifier").setViewName("verifier/verifier");
        registry.addViewController("/client").setViewName("client/client");

    }
}
