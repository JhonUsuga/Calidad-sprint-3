package co.edu.udea.certificacion.couriersync.interactions;

import co.edu.udea.certificacion.couriersync.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class Logoutcouriersync implements Interaction {

    // Botón "Cerrar sesión" del navbar
    public static final Target LOGOUT_BUTTON = Target.the("Logout button")
            .locatedBy("//header//button[normalize-space()='Cerrar sesión']");

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