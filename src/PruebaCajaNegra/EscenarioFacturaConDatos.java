package PruebaCajaNegra;

import agregado.Celular;
import personas.Fisica;
import servicios.DomicilioCasa;
import servicios.DomicilioDepto;
import servicios.Factura;
import servicios.Internet100;
import servicios.Internet500;

public class EscenarioFacturaConDatos {
	private Factura factura;
	
	{
		factura=new Factura(new Fisica("Jorge",14125235));
		Internet500 internet500=new Internet500(new DomicilioCasa("assdfaf",1245));
		Internet100 internet100=new Internet100(new DomicilioCasa("hola",1212));
		
		factura.nuevaContratacion(internet500);
		factura.nuevaContratacion(internet100);
		
	}

	public Factura getFactura() {
		return factura;
	}
	
}
