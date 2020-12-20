package PruebaCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import personas.Fisica;
import personas.Persona;

public class TestPersonaFisica {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Fisica persona=new Fisica("Jorge", 31355235);
		String nombre=persona.getNombre();
		int dni=persona.getDNI();
		Assert.assertEquals("Jorge", persona.getNombre());
		Assert.assertEquals(31355235, persona.getDNI());
	}
	
	@Test
	public void testConstructorNombreNull() {
		Fisica persona=new Fisica(null, 31355235);
		String nombre=persona.getNombre();
		int dni=persona.getDNI();
		Assert.assertEquals(null, persona.getNombre());
		Assert.assertEquals(31355235, persona.getDNI());
	}
	
	@Test
	public void testConstructorNombreVacio() {
		Fisica persona=new Fisica("", 31355235);
		String nombre=persona.getNombre();
		int dni=persona.getDNI();
		Assert.assertEquals("", persona.getNombre());
		Assert.assertEquals(31355235, persona.getDNI());
	}
	

	@Test
	public void TestSetDNI() {
		Fisica persona=new Fisica("Jorge", 31355235);
		persona.setDNI(32455236);
		int dni=persona.getDNI();
		Assert.assertEquals(32455236, dni);
	}
	
	@Test
	public void TestSetNombre() {
		Fisica persona=new Fisica("Jorge", 31355235);
		persona.setNombre("Jorge");
		String nombre=persona.getNombre();
		Assert.assertEquals("Jorge", nombre);
	}
	
	@Test
	public void TestSetNombreNull() {
		Fisica persona=new Fisica(null, 31355235);
		persona.setNombre(null);
		String nombre=persona.getNombre();
		Assert.assertEquals(null, nombre);
	}
	
	@Test
	public void TestSetNombreVacio() {
		Fisica persona=new Fisica("", 31355235);
		persona.setNombre("");
		String nombre=persona.getNombre();
		Assert.assertEquals("", nombre);
	}
	
}
