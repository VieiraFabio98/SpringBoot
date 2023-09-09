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
            Cliente cliente = new Cliente();
            cliente.setNome("Fabio");
            clientes.create(cliente);

            Cliente cliente2 = new Cliente("Marcelly");
            clientes.create(cliente2);

            List<Cliente> allClients = clientes.list();
            allClients.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
