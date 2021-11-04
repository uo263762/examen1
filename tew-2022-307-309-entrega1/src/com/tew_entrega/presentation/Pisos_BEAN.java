package com.tew_entrega.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.tew_entrega.business.templates.Piso_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Piso;

@ManagedBean(name="Pisos_BEAN")
@SessionScoped
public class Pisos_BEAN implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pisos_BEAN() {
		// TODO Auto-generated constructor stub
	}
	
	@ManagedProperty(value="#{Piso_BEAN}")
	Piso_BEAN piso;

	public Piso_BEAN getPiso() {
		return piso;
	}
	

	public void setPiso(Piso_BEAN piso) {
		this.piso = piso;
	}

	List<Piso> pisos;
	
	public List<Piso> getPisos() {
		return pisos;
	}

	public void setPisos(List<Piso> pisos) {
		this.pisos = pisos;
	}
	
	float filtro_precio_inferior;
	float filtro_precio_superior;
	String filtro_ciudad;
	
	

	public float getFiltro_precio_inferior() {
		return filtro_precio_inferior;
	}


	public void setFiltro_precio_inferior(float filtro_precio_inferior) {
		this.filtro_precio_inferior = filtro_precio_inferior;
	}


	public float getFiltro_precio_superior() {
		return filtro_precio_superior;
	}


	public void setFiltro_precio_superior(float filtro_precio_superior) {
		this.filtro_precio_superior = filtro_precio_superior;
	}


	public String getFiltro_ciudad() {
		return filtro_ciudad;
	}


	public void setFiltro_ciudad(String filtro_ciudad) {
		this.filtro_ciudad = filtro_ciudad;
	}


	public String listado() {
		Piso_SERVICE service = Factories.services.createPisoSERVICE();
		List<Piso> pisos = null;
		try {
			pisos = service.getPisos();
			this.pisos = pisos;
		} catch (Exception e) {e.printStackTrace();}
		return "EXITO";
	}
	
	public String listadoFiltroCIUDAD() {
		Piso_SERVICE service = Factories.services.createPisoSERVICE();
		List<Piso> pisos = null;
		try {
			pisos = service.getPisosFiltroCIUDAD(this.filtro_ciudad);
			this.pisos = pisos;
		} catch (Exception e) {e.printStackTrace();}
		return "EXITO";
	}
	
	public String listadoFiltroPRECIO() {
		Piso_SERVICE service = Factories.services.createPisoSERVICE();
		List<Piso> pisos = null;
		try {
			pisos = service.getPisosFiltroPRECIO(this.filtro_precio_inferior, this.filtro_precio_superior);
			this.pisos = pisos;
			
			for (Piso p : pisos) System.out.println(p.getDireccion());
		} catch (Exception e) {e.printStackTrace();}
		return "EXITO";
	}

	
	public String borrar(Piso p) {
		Piso_SERVICE service = Factories.services.createPisoSERVICE();
		Boolean resultado = false;
		try {
			resultado = service.delete(p);
			this.listado();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}
	
	//Este metodo, es un metodo observador.
	// Salvar mira si tiene que actualizar o crear un piso n
	public String salvar() {
		Piso_SERVICE service = Factories.services.createPisoSERVICE();
		Boolean resultado = false;
		try {
			// Añadimos el id del agente que lo guarda.
			this.piso.setId_agente(getAgenteId());
			if (this.piso.getId() == null) resultado = service.save(this.piso);
			if (this.piso.getId() != null) resultado = service.update(this.piso);
			this.listado();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}
	
	private int getAgenteId() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Agente agente = (Agente) session.get("USUARIO");
		return agente.getId();
	}
	
	
	
	@PostConstruct
	public void init() {
		
		this.piso = (Piso_BEAN) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Piso_BEAN");
		if (this.piso == null) this.piso = new Piso_BEAN(); FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Piso_BEAN", this.piso);
		
	}
	
	
}

