package co.edu.udea.certificacion.couriersync.interactions;

import co.edu.udea.certificacion.couriersync.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class Logoutcouriersync implements Interaction {

    public static final Target LOGOUT_BUTTON = Target.the("Logout button")
            .locatedBy("//*[@id='main-content']/header/div/div[2]/button[2]");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LOGOUT_BUTTON)
        );
        WaitTime.putWaitTimeOf(800);
    }

    public static Logoutcouriersync logout() {
        return Tasks.instrumented(Logoutcouriersync.class);
    }
}
