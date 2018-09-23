package unlam.edu.ar.pb2;

public class CajaDeAhorros extends Cuenta {

	public CajaDeAhorros(String titular, Integer dni, Double saldo) {
		super(titular, dni, saldo);
	}

	
	@Override
	public void extraer(Double extraccion) {
		
		int cantidadExtracciones=0;
	
		if(getSaldo()>= extraccion) {
			setSaldo(getSaldo()-extraccion);
			cantidadExtracciones++;
		}
		int importeAdicional=6;
		if (cantidadExtracciones>5) {
			setSaldo(getSaldo()-importeAdicional);
		}					
		} 
		
	
	}
	

