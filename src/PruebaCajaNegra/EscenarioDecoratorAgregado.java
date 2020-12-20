package PruebaCajaNegra;

import agregado.Celular;
import servicios.DomicilioCasa;
import servicios.Internet100;

public class EscenarioDecoratorAgregado {

	private int cantLineas;
	private Celular celular;
	
	{
		cantLineas=3;
		celular=new Celular(3, new Internet100(new DomicilioCasa("asafa",1212)));
	}
		
	
	public int getCantLineas() {
		return cantLineas;
	}
	
	public Celular getCelular() {
		return celular;
	}
}
