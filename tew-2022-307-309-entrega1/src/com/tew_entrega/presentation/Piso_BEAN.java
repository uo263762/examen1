package com.tew_entrega.presentation;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import com.tew_entrega.business.templates.Piso_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Piso;

@ManagedBean(name="Piso_BEAN")
@SessionScoped
public class Piso_BEAN extends Piso implements Serializable {

	private static final long serialVersionUID = 1L;

	public Piso_BEAN() {
		iniciaPiso(null);
	}

	public void iniciaPiso(ActionEvent event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ResourceBundle bundle = fc.getApplication().getResourceBundle(fc, "msgs");
		this.setId_agente(0);
		this.setPrecio(0);
		this.setDireccion(bundle.getString("default_piso_direccion"));
		this.setCiudad(bundle.getString("default_piso_ciudad"));
		this.setAno(Calendar.getInstance().get(Calendar.YEAR));
		this.setEstado(0);

	}
	
	public void setPiso(Piso piso) {
		this.setId(piso.getId());
		this.setId_agente(piso.getId_agente());
		this.setPrecio(piso.getPrecio());
		this.setDireccion(piso.getDireccion());
		this.setCiudad(piso.getCiudad());
		this.setAno(piso.getAno());
		this.setEstado(piso.getEstado());
	}

	public String salvar() {
		Piso_SERVICE service = Factories.services.createPisoSERVICE();
		Boolean resultado = false;
		try {
			// Añadimos el id del agente que lo guarda
			this.setId_agente(getAgenteId());
			if (this.getId() == null) resultado = service.save(this);
			if (this.getId() != null) resultado = service.update(this);
			//this.listado();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}
	
	private int getAgenteId() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Agente agente = (Agente) session.get("USUARIO");
		return agente.getId();
	}
	
}
