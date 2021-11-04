package com.tew_entrega.business.templates;

import java.util.List;

import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Piso;

public interface Cliente_SERVICE {
	
	List<Cliente> getClientes() throws Exception;
	
	boolean save(Cliente c) throws Exception;
	boolean update(Cliente c) throws Exception;
	boolean delete(Cliente c) throws Exception;
	Cliente findById(int id) throws Exception;
	
	

}
