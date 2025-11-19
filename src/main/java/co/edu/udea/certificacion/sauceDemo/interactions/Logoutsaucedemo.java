package co.edu.udea.certificacion.sauceDemo.interactions;
import co.edu.udea.certificacion.sauceDemo.utils.WaitTime;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class Logoutsaucedemo implements Interaction {

    public static final Target MENU_BUTTON = Target.the("Menu button")
            .locatedBy("//*[@id='react-burger-menu-btn']");

    public static final Target LOGOUT_BUTTON = Target.the("Logout button")
            .locatedBy("//*[@id='logout_sidebar_link']");

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(MENU_BUTTON)
        );
        WaitTime.putWaitTimeOf(800);
        actor.attemptsTo(
                Click.on(LOGOUT_BUTTON)
        );
        WaitTime.putWaitTimeOf(800);
    }


    public static Logoutsaucedemo logout() {
        return Tasks.instrumented(Logoutsaucedemo.class);
    }
}
