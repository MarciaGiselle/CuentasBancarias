package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentas {

	//No puedo inicializar una clase abstracta
	/*@Test
	public void test() {
		Cuenta miCuenta = new Cuenta("pepe",324556,200.0);
		miCuenta.depositar(150.0);
		Double monto= 350.0;
		assertEquals(monto, miCuenta.getSaldo());
		
	}*/
	CuentaSueldo cuenta1 = new CuentaSueldo("Groot", 4567, 0.0);
	CuentaCorriente cuenta2 = new CuentaCorriente("Capi", 4587, 0.0);
	CajaDeAhorros cuenta3 = new CajaDeAhorros("Starlord", 785,0.0);
	Double saldoEsperado= 0.0;
	
	
	@Test
	public void testSePuedenCrearCuentas() {
		assertNotNull(cuenta1);
		assertNotNull(cuenta2);
		assertNotNull(cuenta3);
	}

	@Test 
	public void testSePuedeDespositar() {
		cuenta1.depositar(4000.0);
		cuenta1.depositar(8000.0);
		saldoEsperado= 12000.0;
		assertEquals(saldoEsperado,cuenta1.getSaldo());
		
		cuenta2.depositar(20000.0);
		cuenta2.depositar(5000.0);
		saldoEsperado=25000.0;
		assertEquals(saldoEsperado,cuenta2.getSaldo());
		
		cuenta3.depositar(6000.0);
		cuenta3.depositar(4000.0);
		saldoEsperado=10000.0;
		assertEquals(saldoEsperado,cuenta3.getSaldo());
			
	}
	
	@Test
	public void testSePuedeExtraer() {
		//CuentaSueldo
		cuenta1.depositar(12000.0);
		cuenta1.extraer(7000.0);
		//cuenta1.extraer(2000.0);
		Double saldoEsperado2=5000.0;
		assertEquals(saldoEsperado2,cuenta1.getSaldo());
		
		//CajaDeAhorros
		cuenta3.depositar(8000.0);
		cuenta3.extraer(1000.0);
		cuenta3.extraer(1000.0);
		cuenta3.extraer(1000.0);
		cuenta3.extraer(1000.0);
		cuenta3.extraer(1000.0);
		saldoEsperado=3000.0;
		assertEquals(saldoEsperado,cuenta3.getSaldo());
		
		cuenta3.extraer(1000.0);
		saldoEsperado=1994.0;
		assertEquals(saldoEsperado,cuenta3.getSaldo());
		
		cuenta3.extraer(3000.0);
		System.out.println(cuenta3.getSaldo());
		assertEquals(saldoEsperado,cuenta3.getSaldo());

		//CuentaCorriente
		cuenta2.depositar(2000.0);
		cuenta2.extraer(3000.0);
		saldoEsperado= -1050.0;
		assertEquals(saldoEsperado, cuenta2.getSaldo());
		Double descesperado = 950.0;
		assertEquals(descesperado, cuenta2.getDescubierto());
		cuenta2.extraer(950.0);
		saldoEsperado=
		
		
		
	}
	
}
