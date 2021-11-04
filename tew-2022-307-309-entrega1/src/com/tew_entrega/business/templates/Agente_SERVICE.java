package com.tew_entrega.business.templates;

import java.util.List;

import com.tew_entrega.model.Agente;

public interface Agente_SERVICE {

	List<Agente> getAgentes() throws Exception;
	
	boolean save(Agente a) throws Exception;
	boolean update(Agente a) throws Exception;
	boolean delete(Agente a) throws Exception;
	Agente findById(int id) throws Exception;
	
	void borrar_todo() throws Exception;
}
