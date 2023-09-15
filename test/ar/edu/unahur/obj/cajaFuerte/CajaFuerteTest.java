package ar.edu.unahur.obj.cajaFuerte;

import org.junit.Assert;
import org.junit.Test;

public class CajaFuerteTest {
	@Test
	public void pruebaJunit(){}
	
	@Test
	public void alCrearUnaCajaFuerteLaPuertaEstaAbierta() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		valorObtenido = miCajaFuerte.estaAbierta();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alCrearUnaCajaFuerteLaPodemosAbrirConElCodigoIngresadoAlCrearla(){
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		miCajaFuerte.abrirConClave(1234);
		valorObtenido = miCajaFuerte.estaAbierta();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void alCerrarUnaCajaFuerteDebeQuedarCerrada() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		valorObtenido = miCajaFuerte.estaAbierta();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alAbrirLaCajaDeberiaQuedarAbierta() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		miCajaFuerte.abrir();
		valorObtenido = miCajaFuerte.estaAbierta();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void cuandoCambiamosLaClaveLaCajaAbreConLaClaveNueva(){
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		miCajaFuerte.cambiarClave(1234,4321);
		miCajaFuerte.abrirConClave(4321);
		valorObtenido = miCajaFuerte.estaAbierta();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	@Test
	public void despuesDeAbrirConClaveMaestraYCerrarLaCajaQuedaBloqueada(){
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		miCajaFuerte.abrirConClave(1234);
		valorObtenido = miCajaFuerte.estaBloqueada();
		//

		Assert.assertEquals(valorEsperado, valorObtenido);			
	}

	@Test
	public void mientrasLaCajaEstaBloqueadaNoPuedoAbrirla(){
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		miCajaFuerte.abrirConClave(1234);
		miCajaFuerte.cerrar();
		miCajaFuerte.abrirConClave(1234);
		valorObtenido = miCajaFuerte.estaAbierta();
		//

		Assert.assertEquals(valorEsperado, valorObtenido);			
	}
	@Test
	public void cuandoCambioLaClaveLaCajaSeDesbloquea(){
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		miCajaFuerte.abrirConClave(1234);
		miCajaFuerte.cerrar();
		miCajaFuerte.cambiarClave(1234,5689);
		valorObtenido = miCajaFuerte.estaBloqueada();
		//

		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	@Test
	public void cuandoCambioLaClaveSinUsarLaClaveMaestraCorrectaLaClaveIDNoCambiaYLaCajaNoAbreConElla(){
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		miCajaFuerte.cambiarClave(1257, 5689);
		miCajaFuerte.abrirConClave(5689);
		valorObtenido = miCajaFuerte.estaAbierta();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void cuandoPonemosMalLaClave3VecesLaCajaSeBloquea() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.cerrar();
		miCajaFuerte.cambiarClave(1234, 5689);
		miCajaFuerte.abrirConClave(1111);
		miCajaFuerte.abrirConClave(1111);
		miCajaFuerte.abrirConClave(1111);
		valorObtenido = miCajaFuerte.estaBloqueada();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alBloquearUnaCajaQuedaBloqueada() {
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.bloquear();
		valorObtenido = miCajaFuerte.estaBloqueada();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void alDesbloquearUnaCajaQuedaDesbloqueada() {
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		CajaFuerte miCajaFuerte = dadoQueExisteUnaCajaFuerte();
		//
		miCajaFuerte.desbloquear();
		valorObtenido = miCajaFuerte.estaBloqueada();
		//
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	private CajaFuerte dadoQueExisteUnaCajaFuerte() {
		return new CajaFuerte(1234);
	}
	
	
}

