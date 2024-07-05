package com.distribuida.dao;

import java.util.List;
import com.distribuida.entities.FacturaDetalle;

public interface FacturaDetalleDAO {

	
		// CRUD Basico
	public List<FacturaDetalle> findAll();
	
	public FacturaDetalle findOne(int id);
	
	public void add(FacturaDetalle FacturaDetalle);
	
	public void up(FacturaDetalle FacturaDetalle);
	
	public void del(int id);
	
	// CRUD avanzados

	
	
	
	
	
}
