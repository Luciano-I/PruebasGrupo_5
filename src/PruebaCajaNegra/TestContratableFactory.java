package PruebaCajaNegra;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import agregado.ContratableFactory;
import agregado.DecoratorAgregado;
import excepciones.DomicilioInvalidoException;
import excepciones.ServicioInternetInvalidoException;
import interfaces.I_Contratable;
import servicios.DomicilioDepto;
import servicios.Internet100;

public class TestContratableFactory {

	@Test
	public void testNuevoServicio() {
		ContratableFactory factory = new ContratableFactory();
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99, "depto");
		I_Contratable contratable;
		try {
			contratable = factory.nuevoServicio("internet100",1,1,1,depto);
			boolean esinternet = contratable.isInternet100();
			if ((contratable.getDomicilio().getCalle() != "157") || !esinternet)
				Assert.fail("No se agrego correctamente nuevoServicio Fallo internet o domicilio");			
		} catch (ServicioInternetInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DomicilioInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testNuevoServicioInternetInvalido() {
		ContratableFactory factory = new ContratableFactory();
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99, "depto");
		I_Contratable contratable;
		try {
			factory.nuevoServicio("",1,1,1,depto);
			fail("No se lanzo excepcion");
		} catch (ServicioInternetInvalidoException e) {
			
			e.printStackTrace();
		} catch (DomicilioInvalidoException e) {
			Assert.fail("Debio lanzarse una excepcion de tipo internet");
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testNuevoServicioInternetNull() {
		ContratableFactory factory = new ContratableFactory();
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99, "depto");
		I_Contratable contratable;
		try {
			factory.nuevoServicio("",1,1,1,depto);
			fail("No se lanzo excepcion");
		} catch (ServicioInternetInvalidoException e) {
			
			e.printStackTrace();
		} catch (DomicilioInvalidoException e) {
			Assert.fail("Debio lanzarse una excepcion de tipo internet");
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testNuevoServicioDomicilioNull() {
		ContratableFactory factory = new ContratableFactory();
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99, "depto");
		I_Contratable contratable;
		try {
			factory.nuevoServicio("internet100",1,1,1,null);
			fail("No se lanzo excepcion");
		} catch (ServicioInternetInvalidoException e) {
			Assert.fail("Debio lanzarse una excepcion de tipo DomicilioInvalidoException");
			e.printStackTrace();
		} catch (DomicilioInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNuevoServicioInternetVacioYDomicilioNull() {
		ContratableFactory factory = new ContratableFactory();
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99, "depto");
		I_Contratable contratable;
		try {
			factory.nuevoServicio("",1,1,1,null);
			fail("No se lanzo excepcion");
		} catch (ServicioInternetInvalidoException e) {
			e.printStackTrace();
		} catch (DomicilioInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNuevoServicioInternetNullYDomicilioNull() {
		ContratableFactory factory = new ContratableFactory();
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99, "depto");
		I_Contratable contratable;
		try {
			factory.nuevoServicio(null,1,1,1,null);
			fail("No se lanzo excepcion");
		} catch (ServicioInternetInvalidoException e) {
			e.printStackTrace();
		} catch (DomicilioInvalidoException e) {
			e.printStackTrace();
		}
	}
	
	

}
