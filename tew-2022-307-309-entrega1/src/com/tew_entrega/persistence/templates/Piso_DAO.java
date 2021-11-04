package com.tew_entrega.persistence.templates;

import java.util.List;

import com.tew_entrega.model.Piso;

public interface Piso_DAO {
	
	List<Piso> getPisos() throws Exception;
	
	void save(Piso p) throws Exception;
	void update(Piso p) throws Exception;
	void delete(Piso p) throws Exception;
	Piso findById(int id) throws Exception;
	
	List<Piso> getPisosFiltroCIUDAD(String filtro) throws Exception;

	List<Piso> getPisosFiltroPRECIO(float precio_inferior, float precio_superior) throws Exception;
}
