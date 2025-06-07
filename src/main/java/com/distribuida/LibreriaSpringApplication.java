package com.distribuida;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LibreriaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaSpringApplication.class, args);
	}


//	@Bean
//	CommandLineRunner verificarClientes(ClienteRepository repo) {
//		return args -> {
//			System.out.println("📋 Listando todos los clientes en la base de datos:");
//
//			List<Cliente> clientes = repo.findAll();
//			for (Cliente c : clientes) {
//				System.out.println(c);
//			}
//
//			System.out.println("✔ Total encontrados: " + clientes.size());
//		};
//	}
}
