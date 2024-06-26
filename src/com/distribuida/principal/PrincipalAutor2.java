package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

public class PrincipalAutor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Patrón IoC Inversión de Control		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		AutorDAO autorDAO = context.getBean("autorDAOImpl2", AutorDAO.class);
		
		// CRUD : CREATE , READ, UPDATE, DELETE
		
		// Add   
		Autor autor = new Autor(0,"juan","taipe","pais","av. por ahi...", "0987654321","jtaipe@correo.com");
		//autorDAO.add(autor);
		// Up
		Autor autor2 = new Autor(54,"juan2","taipe2","pais2","av. por ahi...2", "09876543212","jtaipe2@correo.com");
		//autorDAO.up(autor2);
		// del
		autorDAO.del(54);
		//findOne
		//System.out.println("************************* DEL *****************"+autorDAO.findOne(54));
		try{ System.out.println("************************* DEL *****************"+autorDAO.findOne(54));} catch(Exception e) { e.printStackTrace();};
		// findAll
		//List<Autor> autors = AutorDAO.findAll();				
		autorDAO.findAll().forEach(item -> {System.out.println(item.toString());});
			
		context.close();
	}

}
