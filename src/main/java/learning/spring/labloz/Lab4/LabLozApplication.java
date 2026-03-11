package learning.spring.labloz.Lab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication
@EntityScan(basePackages = "learning.spring.labloz.Lab4.Entity")  // где Notes
@EnableJpaRepositories(basePackages = "learning.spring.labloz.Lab4.Repository")
public class LabLozApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabLozApplication.class, args);
    }

}
