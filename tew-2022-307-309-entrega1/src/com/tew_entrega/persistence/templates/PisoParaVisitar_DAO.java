package com.tew_entrega.persistence.templates;

import java.util.List;

import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Piso;
import com.tew_entrega.model.PisoParaVisitar;
import com.tew_entrega.model.Usuario;

public interface PisoParaVisitar_DAO {
	
	List<PisoParaVisitar> getPisosParaVisitar() throws Exception;
	
	void save(PisoParaVisitar ppv) throws Exception;
	void update(PisoParaVisitar ppv) throws Exception;
	void delete(PisoParaVisitar ppv) throws Exception;
	PisoParaVisitar findById(int id) throws Exception;
	
	List<PisoParaVisitar> getPisosParaVisitarFiltroHora(long hora_inferior, long hora_superior) throws Exception;
	List<PisoParaVisitar> getPisosParaVisitarFiltroCliente(Cliente c) throws Exception;
	List<PisoParaVisitar> getPisosParaVisitarFiltroAgente(Agente a) throws Exception;
	List<PisoParaVisitar> getPisosParaVisitarFiltroPiso(Piso p) throws Exception;

}
