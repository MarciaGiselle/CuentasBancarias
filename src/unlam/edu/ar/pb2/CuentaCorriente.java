package unlam.edu.ar.pb2;

public class CuentaCorriente extends Cuenta{

	
	
	public CuentaCorriente(String titular, Integer dni, Double saldo) {
		super(titular, dni, saldo);
		
	}

	@Override
	public void extraer(Double extraccion) {
		
		Double descubierto= 2000.0;
		Double comision=0.05;
		
		if(extraccion>getSaldo()) {
			//giro en descubierto
			if((getSaldo() + descubierto) > extraccion) {
				setSaldo ( (getSaldo()-extraccion) + (comision*(extraccion-getSaldo())));
			}
		
		} 
}
	}
