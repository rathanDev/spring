package jana;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {
            System.out.println("Beans created by spring boot --->");
            String[] names = ctx.getBeanDefinitionNames();
            Arrays.sort(names);
            for(String name: names) {
                System.out.println("name = " + name);
            }
        };
    }

}
