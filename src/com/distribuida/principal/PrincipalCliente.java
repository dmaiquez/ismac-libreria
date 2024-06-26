package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

public class PrincipalCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Patrón IoC Inversión de Control		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		ClienteDAO clienteDAO = context.getBean("clienteDAOImpl", ClienteDAO.class);
		
		// CRUD : CREATE , READ, UPDATE, DELETE
		
		// Add   
		Cliente cliente = new Cliente(0,"123456789","juan","taipe","av. por ahi...", "0987654321","jtaipe@correo.com");
		//clienteDAO.add(cliente);
		// Up
		Cliente cliente2 = new Cliente(39,"1234567892","juan2","taipe2","av. por ahi...2", "09876543212","jtaipe2@correo.com");
		//clienteDAO.up(cliente2);
		// del
		//clienteDAO.del(39);
		//findOne
		System.out.println("************************* DEL *****************"+clienteDAO.findOne(39));
		// findAll
		//List<Cliente> clientes = clienteDAO.findAll();				
		clienteDAO.findAll().forEach(item -> {System.out.println(item.toString());});
			
		context.close();
	}

}
