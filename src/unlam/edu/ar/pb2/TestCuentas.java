package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentas {

	// No puedo inicializar una clase abstracta
	/*
	 * @Test public void test() { Cuenta miCuenta = new Cuenta("pepe",324556,200.0);
	 * miCuenta.depositar(150.0); Double monto= 350.0; assertEquals(monto,
	 * miCuenta.getSaldo());
	 * 
	 * }
	 */
	CuentaSueldo CuentaSueldoGroot = new CuentaSueldo("Groot", 4567, 0.0);
	CuentaCorriente CuentaCorrienteCapi = new CuentaCorriente("Capi", 4587, 0.0);
	CajaDeAhorros CajaAhorroStarLord = new CajaDeAhorros("Starlord", 785, 0.0);
	Double saldoEsperado = 0.0;

	@Test
	public void testSePuedenCrearCuentas() {
		assertNotNull(CuentaSueldoGroot);
		assertNotNull(CuentaCorrienteCapi);
		assertNotNull(CajaAhorroStarLord);
	}

	@Test
	public void testSePuedeDespositar() {
		CuentaSueldoGroot.depositar(4000.0);
		CuentaSueldoGroot.depositar(8000.0);
		saldoEsperado = 12000.0;
		assertEquals(saldoEsperado, CuentaSueldoGroot.getSaldo());

		CuentaCorrienteCapi.depositar(20000.0);
		CuentaCorrienteCapi.depositar(5000.0);
		saldoEsperado = 25000.0;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

		CajaAhorroStarLord.depositar(6000.0);
		CajaAhorroStarLord.depositar(4000.0);
		saldoEsperado = 10000.0;
		assertEquals(saldoEsperado, CajaAhorroStarLord.getSaldo());

	}

	@Test
	public void testSePuedeExtraer() {
		// CuentaSueldo
		CuentaSueldoGroot.depositar(12000.0);
		CuentaSueldoGroot.extraer(7000.0);
		// cuenta1.extraer(2000.0);
		Double saldoEsperado2 = 5000.0;
		assertEquals(saldoEsperado2, CuentaSueldoGroot.getSaldo());

		// CajaDeAhorros
		CajaAhorroStarLord.depositar(8000.0);
		CajaAhorroStarLord.extraer(1000.0);
		CajaAhorroStarLord.extraer(1000.0);
		CajaAhorroStarLord.extraer(1000.0);
		CajaAhorroStarLord.extraer(1000.0);
		CajaAhorroStarLord.extraer(1000.0);
		saldoEsperado = 3000.0;
		assertEquals(saldoEsperado, CajaAhorroStarLord.getSaldo());

		CajaAhorroStarLord.extraer(1000.0);
		saldoEsperado = 1994.0;
		assertEquals(saldoEsperado, CajaAhorroStarLord.getSaldo());

		CajaAhorroStarLord.extraer(3000.0);
		//System.out.println(CajaAhorroStarLord.getSaldo());
		assertEquals(saldoEsperado, CajaAhorroStarLord.getSaldo());

	}

	@Test
	public void sePuedeExtraerCuentaCorriente() {
		// CuentaCorriente
		// prueba con deposito
		CuentaCorrienteCapi.depositar(100.0);
		CuentaCorrienteCapi.extraer(200.0);
		saldoEsperado = -105.0;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

		CuentaCorrienteCapi.extraer(50.0);
		saldoEsperado = -157.5;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

		// no puedo extraer mas que el descubierto..
		CuentaCorrienteCapi.extraer(60.0);
		saldoEsperado = -157.5;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

		// ..ni lo mismo
		CuentaCorrienteCapi.extraer(50.0);
		saldoEsperado = -157.5;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

		// ..si menos
		CuentaCorrienteCapi.extraer(40.0);
		saldoEsperado = -199.5;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

	}

	@Test
	public void sePuedeExtraerCuentaCorrienteSinDposito() {
		// CuentaCorriente
		// prueba sin deposito, saldo en 0
		CuentaCorrienteCapi.extraer(100.0);
		saldoEsperado = -105.0;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

		// saldo en negativo
		CuentaCorrienteCapi.extraer(20.0);
		saldoEsperado = -126.0;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

		// no puedo extraer mas de descubierto
		CuentaCorrienteCapi.extraer(70.0);
		saldoEsperado = -199.5;
		assertEquals(saldoEsperado, CuentaCorrienteCapi.getSaldo());

		Double descubiertoEsperado = 0.5;
		assertEquals(descubiertoEsperado, CuentaCorrienteCapi.getDescubierto());

	}

}
