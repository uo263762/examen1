package com.tew_entrega.business.templates;

import java.util.List;

import com.tew_entrega.model.Piso;

public interface Piso_SERVICE {
	
	List<Piso> getPisos() throws Exception;
	
	boolean save(Piso p) throws Exception;
	boolean update(Piso p) throws Exception;
	boolean delete(Piso p) throws Exception;
	Piso findById(int id) throws Exception;
	
	List<Piso> getPisosFiltroCIUDAD(String filtro) throws Exception;
	
	List<Piso> getPisosFiltroPRECIO(float precio_inferior, float precio_superior) throws Exception;

}
