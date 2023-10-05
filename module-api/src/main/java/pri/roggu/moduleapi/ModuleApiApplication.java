package pri.roggu.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("pri.roggu.modulecore.domain.entity")
@EnableJpaRepositories("pri.roggu.*")
@ComponentScans({
        @ComponentScan(basePackages = "pri.roggu.modulecore.config")
      , @ComponentScan(basePackages = "pri.roggu.modulecore.exception")})
@SpringBootApplication
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}