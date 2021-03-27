package fr.erickfranco.cv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({ @PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:datasource.properties", ignoreResourceNotFound = true) })
public class CvApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvApplication.class, args);
    }

}
