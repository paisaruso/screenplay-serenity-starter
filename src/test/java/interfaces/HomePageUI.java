package interfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;

public class HomePageUI extends PageObject {

	private final By BOTON_CONTINUAR = By.xpath("//*[@id=\"boton-seleccion-tarjeta\"]");
	private final By SOLICITUD_MONTO = By.xpath("//*[@id=\"layoutContainers\"]/div/div[2]/div/div[2]/section/div[3]/div[2]/app-root/div/app-solicitud-monto/section/form/span");
	private final By RADIO_BUTTON_SI = By.xpath("//*[@id=\"opcion-si\"]");
	private final By MONTO_SIMULACION = By.xpath("//*[@id='valor-simulacion']");
	private final By VALOR_PLAZO = By.xpath("//*[@id=\"valor-plazo\"]");
	private final By CAMPO_FECHA = By.xpath("//*[@id=\"campo-fecha\"]");
	private final By BOTON_YEARS = By.xpath("//*[@id=\"mat-datepicker-0\"]/mat-calendar-header/div/div/button[2]");
	private final By BOTON_SIMULAR = By.xpath("//*[@id=\"boton-simular\"]");
	public By getBotonContinuar() {
		return BOTON_CONTINUAR;
	}

	public By getSolicitudMonto() {
		return SOLICITUD_MONTO;
	}

	public By getRadioButtonSi() {
		return RADIO_BUTTON_SI;
	}

	public By getMontoSimulacion() {
		return MONTO_SIMULACION;
	}
	public By getValorPlazo() {
		return VALOR_PLAZO;
	}
	public By geCampoFecha() {
		return CAMPO_FECHA;
	}
	public By geBotonYears() {
		return BOTON_YEARS;
	}
	public By getBotonSimular() {
		return BOTON_SIMULAR;
	}
}
