package PruebaCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import servicios.Domicilio;
import servicios.DomicilioCasa;
import servicios.Internet100;
import servicios.Internet500;
import servicios.Servicio;

public class TestServicio {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructorInternet100() {
		Domicilio domicilio=new DomicilioCasa("asafas",1212);
		Servicio servicio=new Internet100(domicilio);
		Assert.assertEquals("El domicilio se creo correctamente en el Servicio de internet100", domicilio, servicio.getDomicilio());
		
		Servicio servicio2=new Internet100(domicilio, 5);
		int id=servicio2.getID();
		Assert.assertEquals("El domicilio se creo correctamente en el Servicio de internet100", domicilio, servicio2.getDomicilio());
		Assert.assertEquals("El id se creo correctamente en internet100", 5, id);
	}
	

	@Test
	public void testConstructorInternet500() {
		Domicilio domicilio=new DomicilioCasa("asafas",1212);
		Servicio servicio=new Internet500(domicilio);
		Assert.assertEquals("El domicilio se creo correctamente en el Servicio de internet500", domicilio, servicio.getDomicilio());
		
		Servicio servicio2=new Internet500(domicilio, 5);
		int id=servicio2.getID();
		Assert.assertEquals("El domicilio se creo correctamente en el Servicio de internet500", domicilio, servicio2.getDomicilio());
		Assert.assertEquals("El id se creo correctamente en internet500", 5, id);
	}
	
	

}
