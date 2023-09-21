package io.github.vieirafabio98;

import io.github.vieirafabio98.domain.entity.Cliente;
import io.github.vieirafabio98.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente("Fabio"));
            clientes.save(new Cliente("Marcelly"));

            List<Cliente> result = clientes.encontrarPorNome("Marcelly");
            result.forEach(System.out::println);


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
