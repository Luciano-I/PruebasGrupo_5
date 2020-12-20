package PruebaCajaNegra;

import personas.Fisica;
import servicios.DomicilioCasa;
import servicios.Factura;
import servicios.Internet100;
import servicios.Internet500;

public class EscenarioFacturaSinDatos {
private Factura factura;
	
	{
		factura=new Factura(new Fisica("Jorge",14125235));
		
	}

	public Factura getFactura() {
		return factura;
	}
}
