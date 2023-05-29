package Tasks;

import abilities.OpenPageAbility;
import net.serenitybdd.screenplay.Actor;

public class OpenPageTask {
	
	private String strActor;
    private String strUrl;

    public OpenPageTask(String strActor, String strUrl) {
        this.strActor = strActor;
        this.strUrl = strUrl;
    }
	
	public void openPage() {
		Actor actor = Actor.named(strActor);
		actor.attemptsTo(OpenPageAbility.onPage(strUrl));
    }

}
