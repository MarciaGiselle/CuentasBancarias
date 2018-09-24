package unlam.edu.ar.pb2;

public class CuentaCorriente extends Cuenta{

	Double descubierto;
	Double comision;
	Double saldoDeudor;
	
	public CuentaCorriente(String titular, Integer dni, Double saldo) {
		super(titular, dni, saldo);
		this.comision=1.05;
		this.descubierto=2000.0;
		this.saldoDeudor=0.0;
	}

	@Override
	public void extraer(Double extraccion) {
		
		if(getSaldo()>= extraccion) {
			setSaldo(getSaldo()-extraccion);
		}else 
			//giro en descubierto
			if((getSaldo() + descubierto) >= extraccion) {
			
				saldoDeudor+= ((((getSaldo() + descubierto) - extraccion)*comision));
				setSaldo(getSaldo()-getSaldo());
				descubierto-=saldoDeudor;
				
		} 
		
		
		
}

	public Double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(Double descubierto) {
		this.descubierto = descubierto;
	}
	}
