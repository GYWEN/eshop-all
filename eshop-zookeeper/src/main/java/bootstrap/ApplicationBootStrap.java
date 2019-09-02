package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import property.ZkProperties;

@SpringBootApplication(scanBasePackages = "property")
@EnableConfigurationProperties({ZkProperties.class})
public class ApplicationBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootStrap.class,args);
    }
}
