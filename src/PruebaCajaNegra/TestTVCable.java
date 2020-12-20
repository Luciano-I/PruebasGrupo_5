package PruebaCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import agregado.TV_Cable;
import agregado.Telefono;
import servicios.DomicilioCasa;
import servicios.Internet100;

public class TestTVCable {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Internet100 i100=new Internet100(new DomicilioCasa("asafa",1212));
		TV_Cable tv=new TV_Cable(3, i100);
		Assert.assertEquals(3, tv.getCantLineas());
		Assert.assertEquals(i100, tv.getContratable());
	}
	
	@Test
	public void testConstructorNULL() {
		TV_Cable tv=new TV_Cable(3, null);
		Assert.assertEquals(3, tv.getCantLineas());
		Assert.assertEquals(null, tv.getContratable());
	}

	@Test
	public void testSetCantLineas() {
		Internet100 i100=new Internet100(new DomicilioCasa("asafa",1212));
		TV_Cable tv=new TV_Cable(3, i100);
		tv.setCantLineas(5);
		Assert.assertEquals(5, tv.getCantLineas());
	}

}
