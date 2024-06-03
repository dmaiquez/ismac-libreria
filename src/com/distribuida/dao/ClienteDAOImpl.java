package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.Cliente;


@Repository
public class ClienteDAOImpl implements ClienteDAO {

	
	// SELECT * FROM Cliente;   -->> SQL
	// SELECT cl.* FROM Cliente as cl -->> SQL
	
	// from Cliente 			-->> HQL
	// SELECT cl from Cliente cl -->> HQL
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
		
	@Override
	@Transactional
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		
		return session.createQuery("from Cliente", Cliente.class).getResultList();
	}

	
	
	@Override
	public Cliente findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public void add(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void up(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub

	}

}
