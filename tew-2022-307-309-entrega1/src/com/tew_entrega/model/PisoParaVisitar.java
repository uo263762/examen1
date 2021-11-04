package com.tew_entrega.model;

public class PisoParaVisitar {
	
	Integer id;
	Integer id_piso;
	Integer id_cliente;
	Long fecha_hora_cita;
	Integer estado_visita;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_piso() {
		return id_piso;
	}
	public void setId_piso(Integer id_piso) {
		this.id_piso = id_piso;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Long getFecha_hora_cita() {
		return fecha_hora_cita;
	}
	public void setFecha_hora_cita(Long fecha_hora_cita) {
		this.fecha_hora_cita = fecha_hora_cita;
	}
	public Integer getEstado_visita() {
		return estado_visita;
	}
	public void setEstado_visita(Integer estado_visita) {
		this.estado_visita = estado_visita;
	}
	
	

}
