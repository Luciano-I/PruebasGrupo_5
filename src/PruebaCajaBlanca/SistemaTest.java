package PruebaCajaBlanca;

import agregado.ContratableFactory;
import agregado.DecoratorAgregado;
import interfaces.I_Contratable;
import interfaces.I_Pago;
import mediospagos.PagoEfectivo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import personas.Fisica;
import personas.Juridica;
import personas.Persona;
import servicios.Domicilio;
import servicios.DomicilioCasa;
import servicios.Factura;

import java.util.Map;

public class SistemaTest {

    private Sistema sistema = Sistema.getInstancia();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        sistema.getlista().clear();
    }

    @Test
    public void agregarFacturas1() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.agregarFacturas(persona);

        if (sistema.getlista().get(persona.getNombre()) != factura)
            Assert.fail("Se reemplazó una factura ya existente");
    }

    @Test
    public void agregarFacturas2() {
        Fisica persona = new Fisica("Marta", 12345),
                persona2 = new Fisica("Carlos", 12346);
        Factura factura = new Factura(persona),
                factura2 = new Factura(persona2);
        sistema.getlista().put(persona.getNombre(), factura);

        sistema.agregarFacturas(persona2);
        if (sistema.getlista().size() != 2)
            Assert.fail("No se agregó la persona2 correctamente");
    }

    @Test
    public void agregarServicio1() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        try {
            sistema.getlista().put(persona.getNombre(), factura);
            I_Contratable servicio = ContratableFactory.nuevoServicio("INTERNET100", 3, 1, 2, new DomicilioCasa("Bolivar", 4567));
            factura.getListaContrataciones().add(servicio);
            sistema.agregarServicio("Marta", "INTERNET500", 1, 0, 2, new DomicilioCasa("Suipacha", 1234));
            if (!factura.getListaContrataciones().contains(servicio))
                Assert.fail("No se agregó correctamente el servicio");
        } catch (Exception e) {
            Assert.fail("Falló el ContratableFactory por la causa: " + e.getMessage());
        }
    }

    @Test
    public void agregarServicio2() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        try {
            sistema.getlista().put(persona.getNombre(), factura);
            I_Contratable servicio = ContratableFactory.nuevoServicio("INTERNET100", 3, 1, 2, new DomicilioCasa("Bolivar", 4567));
            factura.getListaContrataciones().add(servicio);
            sistema.agregarServicio("Marta", null, 3, 8, 1, new DomicilioCasa("Suipacha", 1234));
            for (I_Contratable elemento : factura.getListaContrataciones()) {
                if (elemento.getDomicilio().getCalle().equals("Suipacha") && elemento.getDomicilio().getAltura() == 1234)
                    Assert.fail("Se agregó el servicio a la factura.");
            }
        } catch (Exception e) {
            Assert.fail("Falló el ContratableFactory por la causa: " + e.getMessage());
        }
    }

    @Test
    public void agregarServicio3() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        try {
            sistema.getlista().put(persona.getNombre(), factura);
            I_Contratable servicio = ContratableFactory.nuevoServicio("INTERNET100", 3, 1, 2, new DomicilioCasa("Bolivar", 4567));
            factura.getListaContrataciones().add(servicio);
            sistema.agregarServicio("Marta", null, 3, 8, 1, null);
            for (I_Contratable elemento : factura.getListaContrataciones()) {
                if (elemento.getDomicilio() == null)
                    Assert.fail("Se agregó el servicio a la factura.");
            }
        } catch (Exception e) {
            Assert.fail("Falló el ContratableFactory por la causa: " + e.getMessage());
        }
    }

    @Test
    public void modificarAgregado() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.agregarServicio(persona.getNombre(), "INTERNET100", 3, 1, 4, new DomicilioCasa("Suipacha", 1234));
        sistema.modificarAgregado("Marta", "Suipacha 1234", "QUITAR", "TVCABLE");
        for (I_Contratable elemento : factura.getListaContrataciones())
            if (elemento.isTV_Cable() && elemento.getDomicilio().getDireccion().equals("Suipacha 1234") && ((DecoratorAgregado) elemento).getCantLineas() != 3)
                Assert.fail("No se quitó correctamente el agregado.");
    }

    @Test
    public void abonar() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.agregarServicio(persona.getNombre(), "INTERNET100", 0, 0, 0, new DomicilioCasa("Suipacha", 1234));
        sistema.abonar(persona.getNombre(), new PagoEfectivo());

        if (factura.getTotalConP() != 680)
            Assert.fail("Hubo un error al abonar.");
    }
    @Test
    public void duplicarFactura1() {
        Fisica persona = new Fisica("Marta",12345);
        Factura factura = new Factura(persona);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.agregarServicio(persona.getNombre(), "INTERNET100", 0, 0, 0, new DomicilioCasa("Suipacha", 1234));
        sistema.duplicarFactura(persona.getNombre());
    }

    @Test
    public void duplicarFactura2() {
        Juridica persona = new Juridica("Apple",307072240);
        Factura factura = new Factura(persona);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.duplicarFactura(persona.getNombre());
    }

    @Test
    public void eliminarContratacion() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.agregarServicio(persona.getNombre(), "INTERNET100", 0, 0, 0, new DomicilioCasa("Suipacha", 1234));
        sistema.eliminarContratacion(persona.getNombre(),"Suipacha 1234");
        if (sistema.getlista().get("Marta")!=null)
            Assert.fail("No se eliminó correctamente");
    }

    @Test
    public void listarFactura1() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.agregarServicio(persona.getNombre(), "INTERNET500", 0, 0, 0, new DomicilioCasa("Suipacha", 1234));
        if (!sistema.listarFactura(persona.getNombre()).contains("PRECIO TOTAL: 1000"))
            Assert.fail("No se listó correctamente la factura");
    }

    @Test
    public void listarFactura2() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.agregarServicio(persona.getNombre(), "INTERNET500", 0, 0, 0, new DomicilioCasa("Suipacha", 1234));
        sistema.abonar(persona.getNombre(),new PagoEfectivo());
        if (!sistema.listarFactura(persona.getNombre()).contains("PRECIO TOTAL SIN DESCUENTO: 1000"))
            Assert.fail("No se listó correctamente la factura");
    }

    @Test
    public void listarFacturas() {
        Fisica persona = new Fisica("Marta", 12345);
        Factura factura = new Factura(persona);
        Fisica persona2 = new Fisica("Carlos", 12346);
        Factura factura2 = new Factura(persona2);
        sistema.getlista().put(persona.getNombre(), factura);
        sistema.getlista().put(persona2.getNombre(), factura2);
        sistema.agregarServicio(persona.getNombre(), "INTERNET500", 0, 0, 0, new DomicilioCasa("Suipacha", 1234));
        sistema.agregarServicio(persona2.getNombre(), "INTERNET100", 0, 0, 0, new DomicilioCasa("Suipacha", 1235));

        sistema.abonar(persona.getNombre(),new PagoEfectivo());
        if (!sistema.listarFacturas().contains("Persona fisica Nombre= Marta DNI=12345") || !sistema.listarFacturas().contains("Persona fisica Nombre= Carlos DNI=12346"))
            Assert.fail("No se listaron correctamente las facturas.");
    }
}