package PruebaCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import agregado.Celular;
import servicios.DomicilioCasa;
import servicios.Internet100;

public class TestCelular {

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Internet100 i100=new Internet100(new DomicilioCasa("asafa",1212));
		Celular cel=new Celular(3, i100);
		Assert.assertEquals(3, cel.getCantLineas());
		Assert.assertEquals(i100, cel.getContratable());
	}
	
	@Test
	public void testConstructorNULL() {
		Celular cel=new Celular(3, null);
		Assert.assertEquals(3, cel.getCantLineas());
		Assert.assertEquals(null, cel.getContratable());
	}

	@Test
	public void testSetCantLineas() {
		Internet100 i100=new Internet100(new DomicilioCasa("asafa",1212));
		Celular cel=new Celular(3, i100);
		cel.setCantLineas(5);
		Assert.assertEquals(5, cel.getCantLineas());
	}

}
