package PruebaCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import agregado.Celular;
import agregado.Telefono;
import servicios.DomicilioCasa;
import servicios.Internet100;

public class TestTelefono {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Internet100 i100=new Internet100(new DomicilioCasa("asafa",1212));
		Telefono tel=new Telefono(3, i100);
		Assert.assertEquals(3, tel.getCantLineas());
		Assert.assertEquals(i100, tel.getContratable());
	}
	
	@Test
	public void testConstructorNULL() {
		Telefono tel=new Telefono(3, null);
		Assert.assertEquals(3, tel.getCantLineas());
		Assert.assertEquals(null, tel.getContratable());
	}

	@Test
	public void testSetCantLineas() {
		Internet100 i100=new Internet100(new DomicilioCasa("asafa",1212));
		Telefono tel=new Telefono(3, i100);
		tel.setCantLineas(5);
		Assert.assertEquals(5, tel.getCantLineas());
	}


}
