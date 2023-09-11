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
            //criar cliente
            System.out.println("Criando os Clientes");
            clientes.save(new Cliente("Fabio"));
            clientes.save(new Cliente("Marcelly"));

            //listar cliente
            System.out.println("Listando os clientes");
            List<Cliente> allClients = clientes.findAll();
            allClients.forEach(System.out::println);

            //atualizar cliente
            System.out.println("Atualizando os Clientes");
            allClients.forEach(cliente -> {
                cliente.setNome(cliente.getNome() + " atualizado.");
                clientes.save(cliente);
            });

            allClients = clientes.findAll();
            allClients.forEach(System.out::println);

            //buscando cliente
            System.out.println("Buscando cliente que tenha Mar no nome");
            clientes.findByNomeLike("Mar").forEach(System.out::println);

            //deletar clientes
            System.out.println("Deletando os clientes");
            clientes.findAll().forEach(cliente -> {
                clientes.delete(cliente);
            });

            allClients = clientes.findAll();
            if(allClients.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else{
                allClients.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
