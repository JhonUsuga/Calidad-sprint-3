package co.edu.udea.certificacion.sauceDemo.interactions;

import co.edu.udea.certificacion.sauceDemo.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import static co.edu.udea.certificacion.sauceDemo.userinterfaces.LoginInterface.*;

public class LoginWithEmptyPassword implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(USERNAME_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Enter.theValue("userbad").into(USERNAME_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Clear.field(PASSWORD_TEXT_BOX));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Scroll.to(LOGIN_BUTTON));
        WaitTime.putWaitTimeOf(800);

        actor.attemptsTo(Click.on(LOGIN_BUTTON));
    }
    public static LoginWithEmptyPassword tryLogin() {
        return Tasks.instrumented(LoginWithEmptyPassword.class);
    }
}