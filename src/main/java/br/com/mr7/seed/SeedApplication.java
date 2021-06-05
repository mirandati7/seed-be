package br.com.mr7.seed;

import br.com.mr7.seed.model.Customer;
import br.com.mr7.seed.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeedApplication {

    /*
    @Bean
    public CommandLineRunner run(@Autowired CustomerRepository repository) {
        return  args -> {
            Customer customer = Customer.builder().document("12345678900").name("ALEX").build();
            repository.save(customer);
        };
    }
    */



    public static void main(String[] args) {
        SpringApplication.run(SeedApplication.class,args);
    }

}
