package definitions;

import Tasks.OpenPageTask;
import interfaces.HomePageUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import static net.serenitybdd.core.Serenity.getDriver;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenPageDefinition {

	@Given("abra la pagina de Bancolombia")
	public void openPage() {
		OpenPageTask openPageTask = new OpenPageTask("Automation", "https://www.bancolombia.com/personas/creditos/consumo/credito-libre-inversion/simulador-libre-inversion");
		openPageTask.openPage();
	}


	@When("hago clic en {string}")
	public void hagoClicEn(String string) {
		HomePageUI homePage = new HomePageUI(); // Crear una instancia de la clase HomePageUI
		By botonContinuar = homePage.getBotonContinuar(); // Obtener el objeto By del botón "Continuar"
		WebElement boton = getDriver().findElement(botonContinuar); // Encontrar el elemento del botón en la página

		boton.click(); // Realizar clic en el botón "Continuar"
	}



	@Then("se me presenta la pregunta {string}")
	public void seMePresentaLaPregunta(String pregunta) {
		HomePageUI homePage = new HomePageUI();
		By solicitudMonto = homePage.getSolicitudMonto();
		WebElement preguntaElement = getDriver().findElement(solicitudMonto);

		String textoPregunta = preguntaElement.getText();

		Assert.assertEquals(pregunta, textoPregunta);
	}

	@When("doy clic en la opción {string}")
	public void doyClicEnLaOpción(String opcion) {
		HomePageUI homePage = new HomePageUI();
		By radioButtonSi = homePage.getRadioButtonSi();
		WebElement radioButtonElement = getDriver().findElement(radioButtonSi);

		radioButtonElement.click();
	}


	@When("ingreso un monto aleatorio entre 1.000.000 y 500.000.000")
	public void ingresoMontoAleatorio() {
		Random random = new Random();
		int valor = random.nextInt(500000000 - 1000000 + 1) + 1000000;

		HomePageUI homePage = new HomePageUI();
		By solicitudMonto = homePage.getSolicitudMonto();
		WebElement montoElement = getDriver().findElement(By.xpath("//*[@id='valor-simulacion']"));

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		// Espera de 2 segundos para permitir que el campo esté listo para interactuar
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Esperar hasta que el campo de monto sea visible y esté habilitado
		wait.until(ExpectedConditions.visibilityOf(montoElement));
		wait.until(ExpectedConditions.elementToBeClickable(montoElement));

		// Realizar un clic en el campo de monto
		montoElement.click();
		// Seleccionar el texto existente en el campo utilizando XPath
		montoElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Ingresar el valor aleatorio en el campo de entrada y esperar hasta que se actualice correctamente
		montoElement.sendKeys(String.valueOf(valor));
	}

	@When("ingreso un plazo en meses aleatorio entre {int} y {int}")
	public void ingresoUnPlazoEnMesesAleatorioEntreY(Integer minPlazo, Integer maxPlazo) {
		Random random = new Random();
		int plazo = random.nextInt(maxPlazo - minPlazo + 1) + minPlazo;

		HomePageUI homePage = new HomePageUI();
		By valorPlazo = homePage.getValorPlazo();
		WebElement plazoElement = getDriver().findElement(valorPlazo);

		WebDriverWait wait = new WebDriverWait(getDriver(), 10);

		// Esperar hasta que el campo de plazo sea visible y esté habilitado
		wait.until(ExpectedConditions.visibilityOf(plazoElement));
		wait.until(ExpectedConditions.elementToBeClickable(plazoElement));

		// Limpiar el campo de entrada y esperar hasta que se borre completamente
		plazoElement.clear();
		wait.until(ExpectedConditions.textToBePresentInElementValue(plazoElement, ""));

		// Ingresar el valor aleatorio en el campo de entrada y esperar hasta que se actualice correctamente
		plazoElement.sendKeys(String.valueOf(plazo));
		wait.until(ExpectedConditions.textToBePresentInElementValue(plazoElement, String.valueOf(plazo)));
	}
	@When("doy click en el campo fecha de naciemiento")
	public void doyClickEnElCampoFechaDeNaciemiento() {
		HomePageUI homePage = new HomePageUI();
		By campoFecha = homePage.geCampoFecha();
		WebElement campoFechaElement = getDriver().findElement(campoFecha);

		// Realizar un clic en el campo de fecha
		campoFechaElement.click();
	}
	private int clicksEnBotonAnio;

	@When("doy click en el boton año")
	public void doyClickEnElBotonAño() {
		HomePageUI homePage = new HomePageUI();
		By botonYears = homePage.geBotonYears();
		WebElement botonYearsElement = getDriver().findElement(botonYears);

		Random random = new Random();
		clicksEnBotonAnio = random.nextInt(2); // Generar un número aleatorio entre 0 y 1

		for (int i = 0; i < clicksEnBotonAnio; i++) {
			botonYearsElement.click();
		}
	}

	@When("doy click en el año")
	public void doyClickEnElAño() {
		HomePageUI homePage = new HomePageUI();
		By botonYears = homePage.geBotonYears();
		WebElement botonYearsElement = getDriver().findElement(botonYears);

		Random random = new Random();
		int index1 = (clicksEnBotonAnio == 2) ? random.nextInt(5) + 2 : random.nextInt(6) + 1;
		int index2 = (clicksEnBotonAnio == 2) ? random.nextInt(3) + 2 : random.nextInt(4) + 1;

		String xpath = "//*[@id=\"mat-datepicker-0\"]/div/mat-multi-year-view/table/tbody/tr[" + index1 + "]/td[" + index2 + "]";
		WebElement elemento = getDriver().findElement(By.xpath(xpath));
		elemento.click();
	}
	@When("doy click en el mes")
	public void doyClickEnElMes() {
		Random random = new Random();
		int index1 = random.nextInt(3) + 2;  // Generar número aleatorio entre 2 y 4
		int index2 = random.nextInt(4) + 1;  // Generar número aleatorio entre 1 y 4

		String xpath = "//*[@id=\"mat-datepicker-0\"]/div/mat-year-view/table/tbody/tr[" + index1 + "]/td[" + index2 + "]";
		WebElement elemento = getDriver().findElement(By.xpath(xpath));
		elemento.click();
	}

	@When("doy click en el dia")
	public void doyClickEnElDia() {
		Random random = new Random();

		String tableXPath = "//*[@id=\"mat-datepicker-0\"]/div";
		List<WebElement> dayElements = getDriver().findElements(By.xpath(tableXPath + "//*[contains(@class, 'mat-calendar-body-cell-content')]"));

		if (!dayElements.isEmpty()) {
			// Escoger un día aleatorio
			int randomIndex = random.nextInt(dayElements.size());
			WebElement selectedDayElement = dayElements.get(randomIndex);
			String selectedDayText = selectedDayElement.getText();

			System.out.println("Día seleccionado: " + selectedDayText);

			try {
				selectedDayElement.click();
			} catch (NoSuchElementException e) {
				System.out.println("No se encontró el elemento para el día seleccionado: " + selectedDayText);
			}
		} else {
			System.out.println("No se encontraron elementos de día en la tabla");
		}
	}

	@When("doy click en el boton simular")
	public void doyClickEnElBotonSimular() {
		HomePageUI homePage = new HomePageUI(); // Crear una instancia de la clase HomePageUI
		By botonSimular = homePage.getBotonSimular(); // Obtener el objeto By del botón "Continuar"
		WebElement boton = getDriver().findElement(botonSimular); // Encontrar el elemento del botón en la página
		boton.click();
		System.out.println("Presiona Enter para continuar...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine(); // Esperar hasta que se presione Enter
		getDriver().quit();
	}

}
