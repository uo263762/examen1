package com.tew_entrega.presentation;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


@ManagedBean(name="Idioma_BEAN")
@SessionScoped
public class Idioma_BEAN implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Locale ENGLISH = new Locale("en");
	private static final Locale SPANISH = new Locale("es");
	private Locale locale = new Locale("es");
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	//
	// Beans inyectado
	//
	
	@ManagedProperty(value="#{Cliente_BEAN}")
	Cliente_BEAN cliente;
	

	public Cliente_BEAN getCliente() {
		return cliente;
	}

	public void setCliente(Cliente_BEAN cliente) {
		this.cliente = cliente;
	}
	
	//
	// Beans inyectado
	//
	
	@ManagedProperty(value="#{Piso_BEAN}")
	Piso_BEAN piso;

	public Piso_BEAN getPiso() {
		return piso;
	}

	public void setPiso(Piso_BEAN piso) {
		this.piso = piso;
	}
	
	//
	// Beans inyectado
	//
	
	@ManagedProperty(value="#{PisoParaVisitar_BEAN}")
	PisoParaVisitar_BEAN piso_para_visitar;
	
	
	public PisoParaVisitar_BEAN getPiso_para_visitar() {
		return piso_para_visitar;
	}

	public void setPiso_para_visitar(PisoParaVisitar_BEAN piso_para_visitar) {
		this.piso_para_visitar = piso_para_visitar;
	}
	
	public void setSpanish(ActionEvent event) {
		locale = SPANISH;
		try {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
			
			// Cambiamos los valores de los beans inyectados.
			if (this.cliente != null)  this.cliente.iniciaCliente(null);
			if (this.piso != null) this.piso.iniciaPiso(null);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setEnglish(ActionEvent event) {
		locale = ENGLISH;
		try {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
			
			// Cambiamos los valores de los beans inyectados.
			if (this.cliente != null)  this.cliente.iniciaCliente(null);
			if (this.piso != null) this.piso.iniciaPiso(null);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// Se inicia correctamente el Managed Bean inyectado si JSF lo hubiera
	// creado
	// y en caso contrario se crea.
	// (hay que tener en cuenta que es un Bean de sesiÃ³n)

	// Se usa @PostConstruct, ya que en el contructor no se sabe todavÃ­a si
	// el MBean ya estaba construido y en @PostConstruct SI.
	@PostConstruct
	public void init() {
		
		this.cliente = (Cliente_BEAN) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Cliente_BEAN");
		if (this.cliente == null) this.cliente = new Cliente_BEAN(); FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Cliente_BEAN", this.cliente);
		
		this.piso = (Piso_BEAN) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Piso_BEAN");
		if (this.piso == null) this.piso = new Piso_BEAN(); FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Piso_BEAN", this.piso);
		
		this.piso_para_visitar = (PisoParaVisitar_BEAN) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PisoParaVisitar_BEAN");
		if (this.piso_para_visitar == null) this.piso_para_visitar = new PisoParaVisitar_BEAN(); FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PisoParaVisitar_BEAN", this.piso_para_visitar);
	
		
	}

}
