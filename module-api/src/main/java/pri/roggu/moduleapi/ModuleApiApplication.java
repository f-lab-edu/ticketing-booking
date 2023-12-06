package pri.roggu.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("pri.roggu.modulecommon.domain.entity")
@EnableJpaRepositories("pri.roggu.*")
@ComponentScans({
          @ComponentScan(basePackages = "pri.roggu.moduleapi.config")
        , @ComponentScan(basePackages = "pri.roggu.moduleapi.exception")
})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}