package unlam.edu.ar.pb2;

public class CajaDeAhorros extends Cuenta {

	Integer cantidadExtracciones;
	Integer importeAdicional;
	
	
	public CajaDeAhorros(String titular, Integer dni, Double saldo) {
		super(titular, dni, saldo);
		this.importeAdicional=6;
		this.cantidadExtracciones=0;
	}

	
	@Override
	public void extraer(Double extraccion) {
		
		if(getSaldo()>= extraccion) {
			setSaldo(getSaldo()-extraccion);
			cantidadExtracciones++;
			
			if (cantidadExtracciones>5) {
				setSaldo(getSaldo()-importeAdicional);
			}					
			} 	
		}
	}
	

