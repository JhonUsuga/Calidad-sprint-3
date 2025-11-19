package co.edu.udea.certificacion.sauceDemo.interactions;

import co.edu.udea.certificacion.sauceDemo.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.edu.udea.certificacion.sauceDemo.userinterfaces.LoginInterface.USERNAME_TEXT_BOX;
import static co.edu.udea.certificacion.sauceDemo.userinterfaces.LoginInterface.PASSWORD_TEXT_BOX;
import static co.edu.udea.certificacion.sauceDemo.userinterfaces.LoginInterface.LOGIN_BUTTON;

public class LoginsaucedemoInteraction implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(USERNAME_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Enter.theValue("standard_user").into(USERNAME_TEXT_BOX));

        actor.attemptsTo(Click.on(PASSWORD_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Enter.theValue("secret_sauce").into(PASSWORD_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Scroll.to(LOGIN_BUTTON));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Click.on(LOGIN_BUTTON));
    }

    public static LoginsaucedemoInteraction userAndPassword() {
        return Tasks.instrumented(LoginsaucedemoInteraction.class);
    }
}
