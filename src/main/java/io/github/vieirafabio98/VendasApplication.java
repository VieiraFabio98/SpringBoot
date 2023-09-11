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
            clientes.create(new Cliente("Fabio"));
            clientes.create(new Cliente("Marcelly"));

            //listar cliente
            System.out.println("Listando os clientes"); 
            List<Cliente> allClients = clientes.list();
            allClients.forEach(System.out::println);

//            //atualizar cliente
//            System.out.println("Atualizando os Clientes");
//            allClients.forEach(cliente -> {
//                cliente.setNome(cliente.getNome() + " atualizado.");
//                clientes.update(cliente);
//            });
//
//            allClients = clientes.list();
//            allClients.forEach(System.out::println);
//
//            //buscando cliente
//            System.out.println("Buscando cliente que tenha Mar no nome");
//            clientes.listByName("Mar").forEach(System.out::println);
//
//            //deletar clientes
//            System.out.println("Deletando os clientes");
//            clientes.list().forEach(cliente -> {
//                clientes.delete(cliente);
//            });
//
//            allClients = clientes.list();
//            if(allClients.isEmpty()){
//                System.out.println("Nenhum cliente encontrado");
//            }else{
//                allClients.forEach(System.out::println);
//            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
