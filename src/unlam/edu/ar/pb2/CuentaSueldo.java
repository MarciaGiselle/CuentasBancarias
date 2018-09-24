package unlam.edu.ar.pb2;

public class CuentaSueldo extends Cuenta {

	public CuentaSueldo(String titular, Integer dni, Double saldo) {
		super(titular, dni, saldo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void extraer(Double extraccion) {
		if(getSaldo()>= extraccion) {
			setSaldo(getSaldo()-extraccion);
		}
		
	}
	
	
	

}
