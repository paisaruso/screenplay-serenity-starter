package utilities;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.serenitybdd.core.pages.PageObject;

public class ChromeWebDriver extends PageObject {

	// private final Logger logger = LoggerFactory.getLogger(ChromeWebDriver.class);
	WebDriver getDriver = null;

	/**
	 * Método que inicializa y configura chrome web driver de selenium
	 */
	public void webChromeDriver(String url) {
		try {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.merge(capabilities);
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("--disable-features=EnableEphemeralFlashPermission");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("−−lang=es");
			chromeOptions.addArguments("--force-renderer-accessibility");

			HashMap<String, Object> preferences = new HashMap<>();
			chromeOptions.setExperimentalOption("prefs", preferences);

			preferences.put("profile.managed_default_content_settings.javascript", 1);
			preferences.put("profile.default_content_settings.popups", 1);
			preferences.put("profile.content_settings.exceptions.plugins.,.setting", 1);
			preferences.put("download.prompt_for_download", "false");

			chromeOptions.addArguments("--incognito");

			getDriver = new ChromeDriver(chromeOptions);
			getDriver.get(url);

		} catch (Exception e) {
			fail("Falló al instanciar driver web de Chrome");
		}
	}
}
