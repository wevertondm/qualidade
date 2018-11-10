package pkgTemperatura;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TemperaturaTeste {

	Temperatura objTemp;
	@Before
	public void setUp() throws Exception {
		objTemp= new Temperatura();
	}

	@Test
	public void deveriaConverterCelsiusParaFarenheit() {
		assertEquals("Caso1",23,objTemp.celsiusParaFarenheit(-5),0);
		assertEquals("Caso2",32,objTemp.celsiusParaFarenheit(0),0);
		assertEquals("Caso3",64.40,objTemp.celsiusParaFarenheit(18),0);
		
	}

	@Test
	public void deveriaConverterCelsiusParaKelvin() {
		assertEquals("Caso4",268.150,objTemp.celsiusParaKelvin(-5),0);
		assertEquals("Caso5",273.150,objTemp.celsiusParaKelvin(0),0);
		assertEquals("Caso6",291.150,objTemp.celsiusParaKelvin(18),0);
	}

	@Test
	public void deveriaClassificarTemperatura() {
		assertTrue("Caso7","NEGATIVA" == objTemp.classificaTemperatura(-5));
		assertTrue("Caso8","ZERO" == objTemp.classificaTemperatura(0));
		assertTrue("Caso9","POSITIVA" == objTemp.classificaTemperatura(18));
		
	}

	@Test
	public void deveriaValidaConversaoCelsiusFarenheit() {
		assertTrue("CASO10", true == objTemp.validaConversaoCelsiusFarenheit(-5,23));
		
	}

}
