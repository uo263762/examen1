package com.tew_entrega.persistence.templates;

import java.util.List;

import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;

public interface Agente_DAO {
	
	List<Agente> getAgentes() throws Exception;
	
	void save(Agente a) throws Exception;
	void update(Agente a) throws Exception;
	void delete(Agente a) throws Exception;
	Agente findById(int id) throws Exception;

	void borrar_todo() throws Exception;
}
