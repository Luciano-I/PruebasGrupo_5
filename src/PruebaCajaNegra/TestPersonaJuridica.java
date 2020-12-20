package PruebaCajaNegra;

import java.text.DecimalFormat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mediospagos.PagoCheque;
import personas.Juridica;

public class TestPersonaJuridica {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Juridica persona=new Juridica("Molinos SA", 313552359);
		String nombre=persona.getNombre();
		int cuit=persona.getCUIT();
		Assert.assertEquals("Molinos SA", persona.getNombre());
		Assert.assertEquals(cuit, persona.getCUIT());
	}
	
	@Test
	public void testConstructorNombreNull() {
		Juridica persona=new Juridica(null, 313552359);
		String nombre=persona.getNombre();
		int cuit=persona.getCUIT();
		Assert.assertEquals(null, persona.getNombre());
		Assert.assertEquals(cuit, persona.getCUIT());
	}
	
	@Test
	public void testConstructorNombreVacio() {
		Juridica persona=new Juridica("", 313552359);
		String nombre=persona.getNombre();
		int cuit=persona.getCUIT();
		Assert.assertEquals("", persona.getNombre());
		Assert.assertEquals(cuit, persona.getCUIT());
	}

	@Test
	public void testSetNombre() {
		Juridica persona=new Juridica("Molinos SA", 313552359);
		persona.setNombre("La Merced");
		Assert.assertEquals("La Merced", persona.getNombre());
	}
	
	@Test
	public void testSetNombreNull() {
		Juridica persona=new Juridica("Molinos SA", 313552359);
		persona.setNombre(null);
		Assert.assertEquals(null, persona.getNombre());
	}
	
	@Test
	public void testSetNombreVacio() {
		Juridica persona=new Juridica("Molinos SA", 313552359);
		persona.setNombre("");
		Assert.assertEquals("", persona.getNombre());
	}
	
	@Test
	public void testSetCUIT() {
		Juridica persona=new Juridica("Molinos SA", 313552359);
		int cuit=334553352;
		persona.setCUIT(cuit);
		Assert.assertEquals(cuit, persona.getCUIT());
	}
	
	@Test
	public void testAplicarPorcentaje() {
		PagoCheque cheque = new PagoCheque();
		Juridica persona=new Juridica("Molinos SA", 313552359);
		double porcentaje = persona.aplicarPorcentaje(cheque, 25);
		DecimalFormat formato = new DecimalFormat("#.000");
		Assert.assertEquals(25*1.15, porcentaje,0);
	}
}
