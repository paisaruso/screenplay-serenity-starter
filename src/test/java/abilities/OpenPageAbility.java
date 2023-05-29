package abilities;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class OpenPageAbility extends PageObject implements Task {

	private final String url;

	public OpenPageAbility(String url) {
		this.url = url;
	}

	public static OpenPageAbility onPage(String url) {
		return new OpenPageAbility(url);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		openAt(url);
	}
}
