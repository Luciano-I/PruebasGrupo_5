package PruebaCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import servicios.DomicilioCasa;
import servicios.DomicilioDepto;

public class TestDomicilio {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructorDomicilioDepto() {
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99, "depto");
		String calle = depto.getCalle();
		int altura = depto.getAltura();
		int piso = depto.getPiso();
		String departamento = depto.getDepartamento();
		Assert.assertEquals("157",calle);
		Assert.assertEquals(999,altura);
		Assert.assertEquals(99,piso);
		Assert.assertEquals("depto",departamento);
	}
	
	@Test
	public void testConstructorDomicilioDeptoCalleNull() {
		DomicilioDepto depto = new DomicilioDepto(null, 999, 99, "depto");
		String calle = depto.getCalle();
		int altura = depto.getAltura();
		int piso = depto.getPiso();
		String departamento = depto.getDepartamento();
		Assert.assertEquals(null,calle);
	}
	
	@Test
	public void testConstructorDomicilioDeptoNull() {
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99,null);
		String calle = depto.getCalle();
		int altura = depto.getAltura();
		int piso = depto.getPiso();
		String departamento = depto.getDepartamento();
		Assert.assertEquals(null,departamento);
	}
	
	@Test
	public void testConstructorDomicilioCasa() {
		DomicilioCasa casa = new DomicilioCasa("hola", 999);
		String calle = casa.getCalle();
		int altura = casa.getAltura();
		Assert.assertEquals("hola",calle);
		Assert.assertEquals(999,altura);
	}
	
	@Test
	public void testConstructorDomicilioCasaCalleVacia() {
		DomicilioCasa casa = new DomicilioCasa("", 999);
		String calle = casa.getCalle();
		int altura = casa.getAltura();
		Assert.assertEquals("",calle);
	}
	
	@Test
	public void testConstructorDomicilioCasaCalleNull() {
		DomicilioCasa casa = new DomicilioCasa(null, 999);
		String calle = casa.getCalle();
		int altura = casa.getAltura();
		Assert.assertEquals(null,calle);
	}

	
	@Test
	public void testSetDepartamento() {
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99,null);
		depto.setDepartamento("depto");
		Assert.assertEquals("depto",depto.getDepartamento() );
	}
	
	@Test
	public void testSetPiso() {
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99,null);
		depto.setPiso(100);
		Assert.assertEquals(100,depto.getPiso());
	}
	
	@Test
	public void testSetAltura() {
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99,null);
		depto.setAltura(100);
		Assert.assertEquals(100,depto.getAltura());
	}
	
	@Test
	public void testSetCalle() {
		DomicilioDepto depto = new DomicilioDepto("157", 999, 99,null);
		depto.setCalle("Primera Junta");
		Assert.assertEquals("Primera Junta",depto.getCalle());
	}
	
	
}
