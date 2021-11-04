package com.tew_entrega.infrastructure;


import com.tew_entrega.business.Busniess_FACTORY;
import com.tew_entrega.business.Busniess_FACTORY_IMPL;
import com.tew_entrega.persistence.Persistance_FACTORY;
import com.tew_entrega.persistence.Persistance_FACTORY_IMPL;


// En esta factoria indicmaos que OTRAS FACTORIAS.
public class Factories {

	public static Busniess_FACTORY services = new Busniess_FACTORY_IMPL();
	public static Persistance_FACTORY persistance = new Persistance_FACTORY_IMPL();

}
