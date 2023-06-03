package tz.co.vodacom.bujikun.kitchenstories.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
public class AppConfig {

    @Bean
    public WebMvcConfigurer webMvc(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .maxAge(0)
                        .allowedMethods("GET","POST","DELETE")
                        .allowedOrigins("http://localhost:3000");
            }
        };
    }
}
