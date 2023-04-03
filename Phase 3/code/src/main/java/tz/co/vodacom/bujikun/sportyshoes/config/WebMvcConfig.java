package tz.co.vodacom.bujikun.sportyshoes.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {
    @Bean
    public void imgPath(){
        Path path = FileSystems.getDefault().getPath("");//get current dir
        Path uploadedImgsFolder = path.toAbsolutePath().resolve("imgs");
        if(!Files.exists(uploadedImgsFolder)){
            //create directory
            try {
                Files.createDirectories(uploadedImgsFolder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path currentPath = FileSystems.getDefault().getPath("");//get current directory
        Path imgPath = currentPath.resolve("imgs/");//resolve im
        registry.addResourceHandler("/imgs/**")
                .addResourceLocations("file:"+imgPath.toAbsolutePath()+"/")
                .setCachePeriod(3600)
                .setOptimizeLocations(true)
                .setCacheControl(CacheControl.maxAge(Duration.ofHours(1)));

    }
}
