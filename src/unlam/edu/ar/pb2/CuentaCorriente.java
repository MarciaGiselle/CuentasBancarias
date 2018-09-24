package unlam.edu.ar.pb2;

public class CuentaCorriente extends Cuenta{

	Double descubierto;
	Double comision;
	
	public CuentaCorriente(String titular, Integer dni, Double saldo) {
		super(titular, dni, saldo);
		this.comision=-0.05;
		this.descubierto=200.0;
	}

	@Override
	public void extraer(Double extraccion) {
		
		if(getSaldo()>= extraccion) {
			setSaldo(getSaldo()-extraccion);
		}else 
			//giro en descubierto
			if((getSaldo() + descubierto) >= extraccion && getSaldo()>0) {
				descubierto=extraccion - getSaldo();
				
				//setSaldo ((getSaldo()-extraccion) + (comision*(extraccion-getSaldo())));
				setSaldo(getSaldo()-extraccion+((descubierto)*comision));
						
		} else if (descubierto> extraccion) {
			
			setSaldo(getSaldo()-extraccion+(extraccion*comision));
			descubierto= descubierto -(extraccion)+(extraccion*comision);

		}
}

	public Double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(Double descubierto) {
		this.descubierto = descubierto;
	}
	}
