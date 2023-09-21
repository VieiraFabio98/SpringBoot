package io.github.vieirafabio98;

import io.github.vieirafabio98.domain.entity.Cliente;
import io.github.vieirafabio98.domain.entity.Pedido;
import io.github.vieirafabio98.domain.repository.Clientes;
import io.github.vieirafabio98.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos) {
        return args -> {
            System.out.println("Salvando Clientes");
            Cliente marcelly = new Cliente("Marcelly");
            clientes.save(marcelly);

            Pedido p = new Pedido();
            p.setCliente(marcelly);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

//            Cliente cliente = clientes.findClienteFetchPedidos(marcelly.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidos.findByCliente(marcelly).forEach((System.out::println));


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
