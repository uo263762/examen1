package com.tew_entrega.persistence.templates;

import java.util.List;

import com.tew_entrega.model.Cliente;

public interface Cliente_DAO {
	
	List<Cliente> getClientes() throws Exception;
	
	void save(Cliente c) throws Exception;
	void update(Cliente c) throws Exception;
	void delete(Cliente c) throws Exception;
	Cliente findById(int id) throws Exception;
	
}
